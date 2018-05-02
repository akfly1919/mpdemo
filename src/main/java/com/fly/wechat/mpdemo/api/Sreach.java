package com.fly.wechat.mpdemo.api;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharFilter;
import org.apache.lucene.analysis.charfilter.HTMLStripCharFilter;
import org.apache.lucene.analysis.charfilter.MappingCharFilter;
import org.apache.lucene.analysis.charfilter.NormalizeCharMap;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.wechat.mpdemo.common.BeanUtil;
import com.fly.wechat.mpdemo.common.http.HttpUtils;
import com.fly.wechat.mpdemo.common.http.Response;
import com.fly.wechat.mpdemo.model.AppMsg;

public class Sreach {
	public static final Logger log = Logger.getLogger(Sreach.class);
	public static String listUrl = "https://mp.weixin.qq.com/cgi-bin/appmsg?token=1784825867&lang=zh_CN&f=json&ajax=1"
			+ "&random=0.6832508655347245&action=list_ex&begin=0&count=5&query=&fakeid=&type=9";
	public static String detailUrl = "https://mp.weixin.qq.com/s?__biz=MzA3NTkwMDAwMg"
			+ "==&mid=2649605308&idx=1&sn=f48217ba96a32a7a80733f268194ec84"
			+ "&chksm=877011b1b00798a7f6b1f39832d8bd07b8e9c717f6451287a66a59d288c7ebb6f890444c5fcb#rd";

	public static Analyzer analyzer = new SmartChineseAnalyzer();

	public static String path = "/root/dev/index";
//	public static String path = "./src/main/resources/index";

	public void createIndex(List<AppMsg> list) throws Exception {
		// 将索引存储到内存中
		// Directory directory = new RAMDirectory();
		// 如下想把索引存储到硬盘上，使用下面的代码代替
		Directory directory = FSDirectory.open(Paths.get(path));
		// 写入索引库
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		IndexWriter iwriter = new IndexWriter(directory, config);
		for(AppMsg am:list){
			Document doc = new Document();
			doc.add(new LongField("id" , am.getAppmsgid() , Field.Store.YES ));
			// doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
			doc.add(new TextField("title", am.getTitle(), Field.Store.YES));
			doc.add(new TextField("content", grawDetail(am), Field.Store.YES));
			doc.add(new TextField("Description", am.getDigest(), Field.Store.YES));
			doc.add(new TextField("PicUrl", am.getCover(), Field.Store.YES));
			doc.add(new TextField("Url", am.getLink(), Field.Store.YES));
			iwriter.updateDocument(new Term("id", am.getAppmsgid()+""), doc);
		}
		iwriter.close();
		directory.close();
	}

	public static Map<String,String> queryIndex(String key) throws Exception {
		Map<String,String> map=new HashMap<String,String>();
		Directory directory = FSDirectory.open(Paths.get(path));
		// 读取索引并查询
		DirectoryReader reader = DirectoryReader.open(directory);
		IndexSearcher isearcher = new IndexSearcher(reader);
		// 解析一个简单的查询
//		QueryParser parser = new QueryParser("content", analyzer);
//		MultiFieldQueryParser
//		Query query = parser.parse(key);
		String[] fields = { "title", "content"};  
		Map<String,Float> mapBoots=new HashMap<String,Float>();
		mapBoots.put("title", 0.01f);
		mapBoots.put("content", 2.8f);
		Query query = new MultiFieldQueryParser(fields, analyzer).parse(key.trim());  
		ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
		List<Map<String,String>> items=new ArrayList<Map<String,String>>();
		// 迭代输出结果
		for (int i = 0; i < hits.length&&i<4; i++) {
			System.out.println(hits[i]);
			Document hitDoc = isearcher.doc(hits[i].doc);
			Map<String,String> item=new HashMap<String,String>();
			item.put("Title", hitDoc.get("title"));
			item.put("Description", hitDoc.get("Description"));
			item.put("PicUrl", hitDoc.get("PicUrl"));
			item.put("Url", hitDoc.get("Url"));
			items.add(item);
		}
		map.put("ToUserName", "");
		map.put("FromUserName", "");
		map.put("CreateTime", System.currentTimeMillis()+"");
		map.put("MsgType", "news");
		map.put("ArticleCount", items.size()+"");
		map.put("Articles",BeanUtil.list2xml(items));
		reader.close();
		directory.close();
		return map;
	}

	public String  grawDetail(AppMsg appMsg) throws Exception {
		String json = http(appMsg.getLink(), 1000, "");
		return htmlFilter(json);
	}
	public String htmlFilter(String content) throws Exception{
		StringBuilder sb = new StringBuilder();
        // html过滤
        HTMLStripCharFilter htmlscript = new HTMLStripCharFilter(new StringReader(content));
        
        //增加映射过滤  主要过滤掉换行符
        NormalizeCharMap.Builder builder = new NormalizeCharMap.Builder();
        builder.add( "\r", "" );//回车 
        builder.add( "\t", "" );//横向跳格
        builder.add( "\n", "" );//换行
        CharFilter cs = new MappingCharFilter( builder.build(),htmlscript );
        
        char[] buffer = new char[10240];  
        int count; 
        while ((count = cs.read(buffer)) != -1) {  
            sb.append(new String(buffer, 0, count));  
        }  
        cs.close();
        return sb.toString();
	}
	public List<AppMsg> grawList(int begin,int count) throws Exception {
		String json = http(listUrl.replaceAll("begin=0", "begin="+begin)
				.replaceAll("count=5", "count="+count), 1000, "");
		log.info("grawList json:"+json);
		JSONObject job = JSON.parseObject(json);
		JSONArray ja=job.getJSONArray("app_msg_list");
		List<AppMsg> list=new ArrayList<AppMsg>();
		for(int i=0;i<ja.size();i++){
			list.add(ja.getObject(i, AppMsg.class));
		}
		return list;
	}

	public static String http(String url, int timeout, String params) throws Exception {
		CloseableHttpClient httpClient = HttpUtils.getHttpClient(timeout);
		Response r = null;
		CloseableHttpResponse response = null;
		try {
			log.info("url:" + url);
			HttpPost httpPost = new HttpPost(url);
			try {
				httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
				httpPost.addHeader("Referer",
						"https://mp.weixin.qq.com/cgi-bin/appmsg?t=media/appmsg_edit_v2&action=edit&isNew=1&type=10&token=823056891&lang=zh_CN");
				httpPost.addHeader("Cookie","noticeLoginFlag=1; pac_uid=1_459299295; tvfe_boss_uuid=3e2316bde0f63407; ts_uid=6914649030; mobileUV=1_15a82c414fb_6d258; pgv_pvi=9079758848; RK=OC1mSQBPWX; LW_uid=r1b5S0w182d3k1r3W7b9G7T1Q3; eas_sid=j1X5U0N142B3i1r3H7d9m7E9Z6; LW_sid=l1w590x2T4P2F3V3v2T6V4Y8Z0; qq_slist_autoplay=on; ptcz=704680530c9768e94f0f1433c2ace9b6786c9bf833beff8531454bea2a155c2d; mm_lang=zh_CN; ts_uid=6914649030; pgv_pvid=9073209069; o_cookie=459299295; ua_id=wiskKdhSHxUq3SVFAAAAABhrd_qeIZsL-LZ8mjg_z7A=; pt2gguin=o0459299295; noticeLoginFlag=1; pgv_si=s2981218304; cert=2RMbWZ9qiElroz1B6gkvX4szGtU3HCTR; rewardsn=; _qpsvr_localtk=0.6493009957639986; ptisp=ctc; pgv_info=ssid=s8626634517; user_id=443713014; session_id=dc6760d7fd313867252d2abf; AMCVS_248F210755B762187F000101%40AdobeOrg=1; s_cc=true; wxtokenkey=777; openid2ticket_onQk4t5ohnQxjFVjFmPwb_UwTGGI=JeeeqMQ3uwv9L06LT3MKD5g9/osXZHB1jFcbooFqFVs=; rv2=802040F45B6B4D7111B7990EAEF5889F2803A8544E2688B4BD; property20=53F75624D278F6A350FF77B9F7A40BFCB1A6EE8DE7562AD58284EEB3099A395C61598397009D6E29; s_ppvl=cn%253Aphoto%253Agallery%2C42%2C42%2C925%2C1920%2C925%2C1920%2C1080%2C1%2CL; AMCV_248F210755B762187F000101%40AdobeOrg=-1891778711%7CMCIDTS%7C17621%7CMCMID%7C42878156903894707673759787562300721670%7CMCAAMLH-1523005677%7C11%7CMCAAMB-1523005677%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCAID%7CNONE%7CMCOPTOUT-1522408077s%7CNONE%7CMCSYNCSOP%7C411-17628%7CvVersion%7C2.4.0; s_sq=nbachinaprod%3D%2526pid%253Dcn%25253Aphoto%25253Agallery%2526pidt%253D1%2526oid%253Dfunctiononclick%252528event%252529%25257BmyGallery.changeImage%2525281%252529%25253Breturnfalse%25253B%25257D%2526oidt%253D2%2526ot%253DA; s_ppv=cn%253Aphoto%253Agallery%2C44%2C52%2C1165%2C1920%2C355%2C1920%2C1080%2C1%2CL; uin=o0459299295; luin=o0459299295; ptui_loginuin=459299295; skey=@IXZ98zkpR; lskey=00010000bfd3e478da3b5fc7d1b76f031b0d17781795088205236771a3f95361418f1dc177f0a41d149fedf0; uid=710164881; uuid=f21b5b06086bbcef9c0e5ae4108fd6e7; data_bizuin=3073903005; bizuin=3075900002; data_ticket=b9x5WR2ttTyzgCCZvr9NwokWrIiU02shguIUNqHT4Xxa15g4w1pC7DtG08cqXw3k; slave_sid=VGN2d29XWlNyVTFrZTIwQ09tVVhGM0Faa0hiUUdtSGc0bERjWGJtMHJKSzVpeDhaVVlRWFplZUJSNzVZWllrWTZCelhDNkNXUTF6X1U1djhaNzVaVGlXSG5KbUdHRHJpVHVndEJ2NlVCM2Nlb2p3UmY0NVNudFk5WlRNT1EwMDNQcEh5RFhJU1NkSzdyRDJI; slave_user=gh_308c51629033; xid=047da7986ab3336a24d9364978d8cf77; webwx_data_ticket=gSc2zdx0S84RBB+x/OjpC7Hm; mmad_session=69f67f7a45e6e30294387653c55fd4dcdbc3acf1978fe8ac2fbae74bfee02df7cc92d419f326b636257ad17ada4ca7e4072ceec23feedc0ed32d4b20fba2d3da90fd83c185b8d78cbf5d7924cc4a7b189896d7f8c5e9eced9c32618596ea597111de1c56c245721266e7088080fefde3");
				httpPost.setEntity(new StringEntity(params));
				response = httpClient.execute(httpPost);
				r = new Response();
				r.setStatusCode(response.getStatusLine().getStatusCode());
				if (response.getStatusLine().getStatusCode() == 200) {
					r.setResponseString(EntityUtils.toString(response.getEntity()));
				}
			} catch (Exception e) {
				log.error("", e);
				throw e;
			} finally {
				if (response != null) {
					response.close();
				}
			}
		} finally {
			if (httpClient != null) {
				httpClient.close();
			}
		}
		return r.getResponseString();
	}

	public static void main(String[] args) throws Exception {
		Sreach s=new Sreach();
		for(int i=0;i<10;i=i+5){
			List<AppMsg> list=s.grawList(i,5);
			s.createIndex(list);
		}
//		System.out.println((queryIndex("火箭战术")));
	}
}
