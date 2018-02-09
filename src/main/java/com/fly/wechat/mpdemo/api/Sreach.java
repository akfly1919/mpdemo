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
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
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
	public static String listUrl = "https://mp.weixin.qq.com/cgi-bin/appmsg?"
			+ "token=143857628&lang=zh_CN&f=json&ajax=1"
			+ "&random=0.32591119491729525&action=list_ex&begin=0&count=5&query=&fakeid=&type=9";
	public static String detailUrl = "https://mp.weixin.qq.com/s?__biz=MzA3NTkwMDAwMg"
			+ "==&mid=2649605308&idx=1&sn=f48217ba96a32a7a80733f268194ec84"
			+ "&chksm=877011b1b00798a7f6b1f39832d8bd07b8e9c717f6451287a66a59d288c7ebb6f890444c5fcb#rd";

	public static Analyzer analyzer = new SmartChineseAnalyzer();

//	public static String path = "/root/dev/apache-tomcat-9.0.4/webapps/ROOT/WEB-INF/classes/index";
	public static String path = "./src/main/resources/index";

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
			// doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
			doc.add(new TextField("title", am.getTitle(), Field.Store.YES));
			doc.add(new TextField("content", grawDetail(am), Field.Store.YES));
			doc.add(new TextField("Description", am.getDigest(), Field.Store.YES));
			doc.add(new TextField("PicUrl", am.getCover(), Field.Store.YES));
			doc.add(new TextField("Url", am.getLink(), Field.Store.YES));
			iwriter.updateDocument(new Term("id", am.getAid()), doc);
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
		QueryParser parser = new QueryParser("content", analyzer);
		Query query = parser.parse(key);
		ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
		List<Map<String,String>> items=new ArrayList<Map<String,String>>();
		// 迭代输出结果
		for (int i = 0; i < hits.length&&i<8; i++) {
			System.out.println(hits[i]);
			Document hitDoc = isearcher.doc(hits[i].doc);
			Map<String,String> item=new HashMap<String,String>();
			item.put("Title", hitDoc.get("title"));
			item.put("Description", hitDoc.get("Description"));
			item.put("PicUrl", hitDoc.get("PicUrl"));
			item.put("Url", hitDoc.get("Url"));
			System.out.println(hitDoc.get("Url"));
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
						"https://mp.weixin.qq.com/cgi-bin/appmsg?t=media/appmsg_edit_v2&action=edit&isNew=1&type=10&token=143857628&lang=zh_CN");
				httpPost.addHeader("Cookie",
						"noticeLoginFlag=1; pac_uid=1_459299295; tvfe_boss_uuid=3e2316bde0f63407; "
								+ "ts_uid=6914649030; mobileUV=1_15a82c414fb_6d258; pgv_pvi=9079758848; "
								+ "RK=OC1mSQBPWX; LW_uid=r1b5S0w182d3k1r3W7b9G7T1Q3; eas_sid=j1X5U0N142B3i1r3H7d9m7E9Z6;"
								+ " LW_sid=l1w590x2T4P2F3V3v2T6V4Y8Z0; qq_slist_autoplay=on; noticeLoginFlag=1; "
								+ "ptcz=704680530c9768e94f0f1433c2ace9b6786c9bf833beff8531454bea2a155c2d; "
								+ "mm_lang=zh_CN; ts_uid=6914649030; pgv_pvid=9073209069; o_cookie=459299295; "
								+ "ua_id=wiskKdhSHxUq3SVFAAAAABhrd_qeIZsL-LZ8mjg_z7A=; pgv_info=ssid=s2796853153; "
								+ "pgv_si=s1127670784; user_id=null; session_id=null; _qpsvr_localtk=0.0662468834318386;"
								+ " ptisp=ctc; luin=o0459299295; cert=ZYEEqlodNi1flrzi93UkSgDi4HlQiXsQ; rewardsn=; "
								+ "openid2ticket_onQk4t5ohnQxjFVjFmPwb_UwTGGI=uLtVqWNtIp9fqrDo9jCQljRpkK4fYVduutCBwYYpA2w=;"
								+ " AMCVS_248F210755B762187F000101%40AdobeOrg=1; s_cc=true; lskey=00010000ff425c113159f552a612e9e83ca9f1fef6c55cd681071df28b35627cec50c772f28cddb3e2a3dca3; AMCV_248F210755B762187F000101%40AdobeOrg=-1891778711%7CMCIDTS%7C17565%7CMCMID%7C42878156903894707673759787562300721670%7CMCAAMLH-1518167213%7C11%7CMCAAMB-1518167213%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCAID%7CNONE%7CMCOPTOUT-1517569613s%7CNONE%7CMCSYNCSOP%7C411-17572%7CvVersion%7C2.4.0; "
								+ "s_ppvl=cn%253Aphoto%253Agallery%2C45%2C45%2C965%2C1920%2C965%2C1920%2C1080%2C1%2CL; s_sq=%5B%5BB%5D%5D; s_ppv=cn%253Anews%253Aarticle%2C35%2C60%2C1665%2C1920%2C965%2C1920%2C1080%2C1%2CL;"
								+ " uid=710164881; mmad_session=69f67f7a45e6e30294387653c55fd4dc21f5b1b46b4cdb127c5fe0e5501c3c62a6af9230b411677ef2a0a8b8f6f20946d7eb1ae4fef04809c0a7945ed2efe873b20a9ebab108dc5bbc4cbf481a6868cb211624ddd88ccd60774f50efaf9d670111de1c56c245721266e7088080fefde3; ptui_loginuin=459299295; pt2gguin=o0459299295; uuid=64315d4d980990303918e37e0b967ead; data_bizuin=3073903005; bizuin=3075900002; data_ticket=t5bN7HX2ncO6QH3AfS3V3gEqiFfsoxujSb4KKbI3SXtrCnoSIsa9whbUV7wjrqEM; "
								+ "slave_sid=UlQ3SDZxa2lwQXNOQXZuYnE1Z09RamR2WlVWN0p6Z0tlZWNWblB4UWRJbnk3ZFAwV19MNFlGMERLTVdlQ01raDZISGRLMzl5MWZ3Vjhla2cyU3dNTUtzUl9mZUNONGxHUmg3a2lPbWpmeUVlbFBfSkdKWTdNS0tRbkNtQmdEOEVUSVNja1BrUW1NMTJ3aUdM; slave_user=gh_308c51629033; xid=b4fc26cc47a44762114313fe6a61c092;"
								+ " webwx_data_ticket=gSchtNs/YPo4K1Ribh+aZZzF; uin=o0459299295; skey=@8OMMlGmWt");
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
		for(int i=0;i<100;i++){
			List<AppMsg> list=s.grawList(0,5);
			s.createIndex(list);
		}
//		String s=BeanUtil.map2xml(queryIndex("勇士")).replaceAll("</item>]]>", "</item>").replaceAll("<!\\[CDATA\\[<item>", "<item>");
//		System.out.println(
//				s);
	}
}
