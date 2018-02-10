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
	public static String listUrl = "https://mp.weixin.qq.com/cgi-bin/appmsg?token=1764663043&lang=zh_CN&f=json&ajax=1"
			+ "&random=0.024366825126301617&action=list_ex&begin=0&count=5&query=&fakeid=&type=9";
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
						"https://mp.weixin.qq.com/cgi-bin/appmsg?t=media/appmsg_edit_v2&action=edit&isNew=1&type=10&token=143857628&lang=zh_CN");
				httpPost.addHeader("Cookie",
						"noticeLoginFlag=1; tvfe_boss_uuid=aa65b200278002eb; mobileUV=1_159da49bc6c_34ee6; "
						+ "_ga=GA1.2.955750067.1487058734; pgv_pvi=5382595584; RK=HL1uGQBOU3; pac_uid=1_459299295; sd_userid=23601503745520873; "
						+ "sd_cookie_crttime=1503745520873; eas_sid=l1q5O0S8g0v5m0l7X7L4d760S4; LW_uid=o1U550x8n0R5i0u7a9o2Q2d9r5; LW_sid=L1k550V991N7u9w9l2T5O9s1Z2; "
						+ "pgv_pvid_new=459299295_158305e4ea1; ptcz=8bed125b016cf50972fd90457ae05447acb9c44ec47cd5dd1fbe24366507a29a; ts_uid=2082215592; "
						+ "ua_id=gALffH3Il5L1c2XBAAAAALbUalVPAbDNTxE30um0gKk=; mm_lang=zh_CN; o_cookie=459299295; pgv_pvid=1643249965; noticeLoginFlag=1; "
						+ "qq_slist_autoplay=on; pt2gguin=o0459299295; luin=o0459299295; lskey=00010000d8488eed2bf781f190cfce21450c3aed9cf17f5659b9354aa6b234af2eced6a5ebad861835b454fe;"
						+ " AMCV_248F210755B762187F000101%40AdobeOrg=-1891778711%7CMCIDTS%7C17566%7CMCMID%7C29742349974197567379094842656072282433%7CMCAAMLH-1518230110%7C11%7CMCAAMB-1518230110%7CRKhpRz8krg2"
						+ "tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCAID%7CNONE%7CMCOPTOUT-1517632510s%7CNONE%7CMCSYNCSOP%7C411-17573%7CvVersion%7C2.4.0; pgv_si=s3340737536;"
						+ " pgv_info=ssid=s5394389504; uin=o0459299295; skey=@8OMMlGmWt; sig_login=h01b5c0af0d234fdf245b6cc55dde6f7b15fa987cda8613fe6ca9776200d2ae0d01a7220357152ca88a; "
						+ "sig=h014deac03a6c72b7d0ef25fcfe07b2db60670d142e5fb1b0337d569313ec309241ad3a217aaf22c1dc; rewardsn=; cert=CJ2pCs4BvNN5PdG5sXHFc4mfwTpHbGgL; uuid=593fcc95b9fbe5655178d87f17bee8b8;"
						+ " ticket=a9d39f83982c0a446c30e061ab161309116546e5; ticket_id=gh_308c51629033; data_bizuin=3073903005; bizuin=3075900002; "
						+ "data_ticket=L/oGKjRF5vq1mxeUDyeakXjiYs768l/t1xrhtxF3J4NqljVkGU98gt8ewShsuui1; slave_sid=VFdqSFZIaGFBbFhJdW9UbVE3am5mSklwTW9zNG1sNlhaQk1qNG9jb1FncXJhUElxaG9sZGtydW5kSHBUbU5YYUZTOTNMRTcwQV9SNGp6QTN3SU9FbDZQNDFaSVA1RzhuVnVEZ3UzVlpVcExSVk1uWmE2M3BhcmRQZUNQMjJlOW9VbUE4SXVtd2FGYW9CMURp; "
						+ "slave_user=gh_308c51629033; xid=79105dfdb425cf2e0e4ed4ce10461183; openid2ticket_onQk4t5ohnQxjFVjFmPwb_UwTGGI=acbLJZPCNn9S9Uy0jiZbeb4hnoHmMJJIePE33xKWQjg=; webwx_data_ticket=gSf1OpQWDqSkmhpkOhob1o7q");
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
//		Sreach s=new Sreach();
//		for(int i=0;i<400;i=i+5){
//			List<AppMsg> list=s.grawList(i,5);
//			s.createIndex(list);
//		}
		System.out.println((queryIndex("火箭战术")));
	}
}
