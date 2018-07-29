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
import org.apache.lucene.search.Sort;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.wechat.mpdemo.common.BeanUtil;
import com.fly.wechat.mpdemo.common.http.HttpUtils;
import com.fly.wechat.mpdemo.common.http.Response;
import com.fly.wechat.mpdemo.model.AppMsg;

public class Sreach {
	public static final Logger log = Logger.getLogger(Sreach.class);
	public static String listUrl = "https://mp.weixin.qq.com/cgi-bin/appmsg?token=935724911&lang=zh_CN&f=json&ajax=1&random=0.9495327386943306&action=list_ex&begin=0&count=5&query=&fakeid=&type=9";
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
		Sort sort=new Sort();
		ScoreDoc[] hits = isearcher.search(query, 1000,sort).scoreDocs;
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
		String json = http(appMsg.getLink().replace("http://", "https://"), 10000, "");
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
						"https://mp.weixin.qq.com/cgi-bin/appmsg?t=media/appmsg_edit_v2&action=edit&isNew=1&type=10&token=653339120&lang=zh_CN");
				httpPost.addHeader("Cookie","noticeLoginFlag=1; tvfe_boss_uuid=aa65b200278002eb; mobileUV=1_159da49bc6c_34ee6; _ga=GA1.2.955750067.1487058734; pgv_pvi=5382595584; RK=HL1uGQBOU3; sd_userid=23601503745520873; sd_cookie_crttime=1503745520873; eas_sid=l1q5O0S8g0v5m0l7X7L4d760S4; LW_uid=o1U550x8n0R5i0u7a9o2Q2d9r5; LW_sid=L1k550V991N7u9w9l2T5O9s1Z2; pgv_pvid_new=459299295_158305e4ea1; ptcz=8bed125b016cf50972fd90457ae05447acb9c44ec47cd5dd1fbe24366507a29a; ts_uid=2082215592; ua_id=gALffH3Il5L1c2XBAAAAALbUalVPAbDNTxE30um0gKk=; mm_lang=zh_CN; pgv_pvid=1643249965; qq_slist_autoplay=on; pt2gguin=o0459299295; o_cookie=459299295; AMCV_248F210755B762187F000101%40AdobeOrg=-1891778711%7CMCIDTS%7C17692%7CMCMID%7C29742349974197567379094842656072282433%7CMCAAMLH-1528984353%7C11%7CMCAAMB-1529122711%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCAID%7CNONE%7CMCOPTOUT-1528525111s%7CNONE%7CMCSYNCSOP%7C411-17697%7CvVersion%7C2.4.0; openid2ticket_onQk4t5ohnQxjFVjFmPwb_UwTGGI=kbxpIt+V/3K1/Qgd2Y7Nkj02zLf4Xje9gQZz8cO0GNs=; luin=o0459299295; lskey=00010000b2bd4353c811e16ca2ed2b1927ccfc488c3cc69079217b0512283f5409810c0122b290392f518b32; pac_uid=1_459299295; pgv_si=s6063904768; cert=pmJx8LZ02uDnHgfxrgkYCKd2iahqJEgO; ptisp=; uin=o0459299295; skey=@nAirH1uhY; pgv_info=ssid=s4593219298; uuid=02f407f15784fe9d501aafba0d2afa4e; data_bizuin=3073903005; bizuin=3075900002; data_ticket=3exqzx9c6ycPe/6WdTetsjmTxzlKRYBa9Er/zmd83RucVOTpKqqbj0y4+c2wL1Rs; slave_sid=OVd5VW12WTZBVlpKMlN2TXJ4eVFBM09JWWNXVlNZbDEyR0E2Z1VfOVNJS1pLQWdLNXh5SDJPQ3R0OWVFSXR2U2Jkekh4Y1V2SWExT3BSaFFMQkluZjNLVUFPNnM1a3ZGS1VnTzIzcDZIeTBlNjNKek93UEJmNVNwWUJuT2JSVUE1QzhPNXNRUnpabVQ5THU5; slave_user=gh_308c51629033; xid=8e82f50e6b6d17f4ba5e5f1b0becdd97; mmad_session=69f67f7a45e6e30294387653c55fd4dc93250229a8152bae8b20da48cb984eef31214846be35dae3b15c70a7d0dc3fa8ff837ee2dabc08d3715817f6676e42286992f0e118f4468d0f3893317d64dd0aac4fe6f5bcb929097ddbb54628fd8b7711de1c56c245721266e7088080fefde3; uid=710164881; rewardsn=; wxtokenkey=777; webwx_data_ticket=gSefrJLOFu7bi4vEbiZpQp5G");
				httpPost.setEntity(new StringEntity(params));
				response = httpClient.execute(httpPost);
				log.info("response:" + response);
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

}
