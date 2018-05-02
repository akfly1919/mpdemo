package com.fly.wechat.mpdemo.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.wechat.mpdemo.common.http.HttpUtils;
import com.fly.wechat.mpdemo.common.http.Response;

public class GrawNba {
	public static final Logger log = Logger.getLogger(GrawNba.class);

	public static String http(String url, int timeout, String params) throws Exception {
		CloseableHttpClient httpClient = HttpUtils.getHttpClient(1000, true);
		Response r = null;
		CloseableHttpResponse response = null;
		try {
			log.info("url:" + url);
			HttpGet httpGet = new HttpGet(url);
			try {
				httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
				httpGet.addHeader("user-agent:",
						"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36");
				response = httpClient.execute(httpGet);
				r = new Response();
				r.setStatusCode(response.getStatusLine().getStatusCode());
				if (response.getStatusLine().getStatusCode() == 200) {
					r.setResponseString(EntityUtils.toString(response.getEntity()));
				}
			} catch (Exception e) {
				log.error("", e);
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
	
	public void sreachNBA(String fileName,Map<String,String> ssmap) throws Exception{
		HtmlCleaner cleaner = new HtmlCleaner();
		// String
		// html=http("http://matchweb.sports.qq.com/kbs/list?from=NBA_PC&columnId=100000&startTime=2017-10-18&endTime=2018-01-01&callback=ajaxExec",
		// 10000, null);
		// TagNode node = cleaner.clean(html);
		// Object[] tables =
		// node.evaluateXPath("//*[@id=\"m10\"]/div[2]/div[2]/div[2]/a/span");
		StringBuffer buffer = new StringBuffer();
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String s = null;
		while ((s = bf.readLine()) != null) {// 使用readLine方法，一次读一行
			buffer.append(s.trim());
		}
		bf.close();
		String html= buffer.toString();
		String json =html.replaceAll("ajaxExec\\(", "");
		JSONObject jo = JSON.parseObject(json.replaceAll("\\)", ""));
		JSONObject ja = jo.getJSONObject("data");
		for (Map.Entry<String, Object> map : ja.entrySet()){
			String value =map.getValue().toString();
			JSONArray matchs=JSON.parseArray(value);
			for(Object obj : matchs){
				JSONObject match=(JSONObject)obj;
				String str=match.getString("leftName")+"VS"+match.getString("rightName")+" "+match.getIntValue("leftGoal")+":"+match.getIntValue("rightGoal");
				if((match.getIntValue("leftGoal")-match.getIntValue("rightGoal"))>0){
					String st1=map.getKey() + str+ "==" 
							+match.getString("leftName")+"|"+match.getString("rightName")+"|1|0";
					ssmap.put(st1,"");
				}else{
					String st1=map.getKey() +str+ "==" 
							+match.getString("leftName")+"|"+match.getString("rightName")+"|0|1";
					ssmap.put(st1,"");
				}
				
			}
		}
	}
	
	public static void go(String a1,String a2) throws Exception{
		String file1="C:\\Users\\fly\\git\\mpdemo\\src\\main\\resources\\2017NBA.txt";
		String file2="C:\\Users\\fly\\git\\mpdemo\\src\\main\\resources\\2018NBA.txt";
		Map<String,String> treeMap=new TreeMap<String,String>();
		Map<String,Integer> socreMap=new TreeMap<String,Integer>();
		socreMap.put(a1,0);
		socreMap.put(a2,0);
		GrawNba gn=new GrawNba();
		gn.sreachNBA(file1, treeMap);
		gn.sreachNBA(file2, treeMap);
		List<String> a1List= getLikeByMap(treeMap, a1+"|"+a2);
		List<String> a2List= getLikeByMap(treeMap, a2+"|"+a1);
		printList(a1List);
		printList(a2List);
		List<String> list=new ArrayList<String>();
		list.addAll(a1List);
		list.addAll(a2List);
		for(String s:list){
			String s1=s.split("==")[1];
			String[] ss=s1.split("\\|");
			socreMap.put(ss[0],socreMap.get(ss[0])+Integer.valueOf(ss[2]));
			socreMap.put(ss[1],socreMap.get(ss[1])+Integer.valueOf(ss[3]));
		}
		System.out.println(a1+"VS"+a2);
		System.out.println(a1+socreMap.get(a1)+"胜"+socreMap.get(a2)+"败");
		System.out.println(a2+socreMap.get(a2)+"胜"+socreMap.get(a1)+"败");
	}

	public static void main(String[] args) throws Exception {
		List<String> list=new ArrayList<String>();
		list.add("雷霆");
		list.add("爵士");
//		list.add("开拓者");
//		list.add("爵士");
//		list.add("鹈鹕");
//		list.add("马刺");
//		list.add("雷霆");
//		list.add("森林狼");
//		list.add("掘金");
		for(int i=0;i<list.size()-1;i++){
			for(int j=i+1;j<list.size();j++){
				go(list.get(i),list.get(j));
				System.out.println();
			}
		}
	}
	public static void printList(List<String> list){
		for(String s:list){
			System.out.println(s);
		}
	}
	public static List<String> getLikeByMap(Map<String, String>map,String keyLike){
        List<String> list=new ArrayList<String>();        
        for (Map.Entry<String, String> entity : map.entrySet()) {
                            if(entity.getKey().indexOf(keyLike)>-1){
                                    list.add(entity.getKey());
                            }

                    }    

        return list;
    }
	

	public Map<String, String> grawNbaList() throws Exception {
		HtmlCleaner cleaner = new HtmlCleaner();
		String urlPref = "https://www.reddit.com";
		Map<String, String> nbas = new HashMap<String, String>();
		String html = http("https://www.reddit.com/r/nbastreams/", 1000, "");
		// TagNode node =cleaner.clean(new
		// File("/Users/panghuiyuan/git/mpdemo/src/main/resources/1.txt"));
		TagNode node = cleaner.clean(html);
		Object[] tables = node.evaluateXPath("//*[@id=\"siteTable\"]");
		if (tables != null && tables.length == 1) {
			TagNode tab = (TagNode) tables[0];
			Object[] divs = tab.evaluateXPath("div");
			for (int i = 0; i < divs.length; i++) {
				TagNode tn = (TagNode) divs[i];
				if (tn.getAttributeByName("class").indexOf("gamethread") != -1) {
					Object[] ns1 = tn.evaluateXPath("/div[2]/div[1]/p[1]/a");
					TagNode tn1 = (TagNode) ns1[0];
					if (tn1.getText().toString().indexOf("Game Thread") != -1) {
						nbas.put("" + tn1.getText(), urlPref + tn1.getAttributeByName("href"));
					}
				}
			}
		}
		return nbas;
	}

	public Set<String> grawUrls(String url) throws Exception {
		HtmlCleaner cleaner = new HtmlCleaner();
		Set<String> set = new HashSet<String>();
		String html = http(url, 3000, "");
		log.info(html);
		// TagNode node =cleaner.clean(new
		// File("/Users/panghuiyuan/git/mpdemo/src/main/resources/2.txt"));
		TagNode node = cleaner.clean(html);
		Object[] tables = node.evaluateXPath("//a[@rel=\"nofollow\"]");
		log.info(tables.length);
		if (tables != null) {
			for (Object obj : tables) {
				TagNode tab = (TagNode) obj;
				String surl = tab.getAttributeByName("href");
				if (surl.startsWith("http") && !surl.startsWith("https://www.reddit.com/")
						&& !surl.startsWith("http://bilasport.me")) {
					if (set.size() < 1) {
						set.add(surl);
					}
				}
				// URL urlss = new URL(tab.getAttributeByName("href"));
				// System.out.println(urlss.getHost());
			}
		}
		return set;
	}

	public Map<String, Set<String>> onlineNba() {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		Map<String, String> nbas = null;
		while (nbas == null) {
			try {
				nbas = grawNbaList();
			} catch (Exception e) {
			}
		}
		for (String key : nbas.keySet()) {
			Set<String> set = null;
			try {
				while (set == null) {
					set = grawUrls(nbas.get(key));
				}
				log.info(set);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			map.put(getKey(key), set);
		}
		return map;
	}

	private String getKey(String key) {
		try {
			int a = key.indexOf(":");
			int b = key.indexOf("@");
			int c = key.indexOf("(");
			return zuMap.get(key.substring(a + 1, b).trim()) + "vs" + zuMap.get(key.substring(b + 1, c).trim());
		} catch (Exception e) {
			return key;
		}
	}

	public static Map<String, String> zuMap = new HashMap<String, String>();
	static {
		zuMap.put("San Antonio Spurs", "马刺");
		zuMap.put("Memphis Grizzlies", "灰熊");
		zuMap.put("Dallas Mavericks", "独行侠");
		zuMap.put("Houston Rockets", "火箭");
		zuMap.put("New Orleans Pelicans", "鹈鹕");
		zuMap.put("Minnesota Timberwolves", "森林狼");
		zuMap.put("Denver Nuggets", "掘金");
		zuMap.put("Utah Jazz", "爵士");
		zuMap.put("Portland Trail Blazers", "开拓者");
		zuMap.put("Oklahoma City Thunder", "雷霆");
		zuMap.put("Sacramento Kings", "国王");
		zuMap.put("Phoenix Suns", "太阳");
		zuMap.put("Los Angeles Lakers", "湖人");
		zuMap.put("Los Angeles Clippers", "快船");
		zuMap.put("Golden State Warriors", "勇士");
		zuMap.put("Miami Heat", "热火");
		zuMap.put("Orlando Magic", "魔术");
		zuMap.put("Atlanta Hawks", "老鹰");
		zuMap.put("Washington Wizards", "奇才");
		zuMap.put("Charlotte Hornets", "黄蜂");
		zuMap.put("Detroit Pistons", "活塞");
		zuMap.put("Indiana Pacers", "步行者");
		zuMap.put("Cleveland Cavaliers", "骑士");
		zuMap.put("Chicago Bulls", "公牛");
		zuMap.put("Milwaukee Bucks", "雄鹿");
		zuMap.put("Boston Celtics", "凯尔特人");
		zuMap.put("Philadelphia 76ers", "76人");
		zuMap.put("New York Knicks", "尼克斯");
		zuMap.put("Brooklyn Nets", "篮网");
		zuMap.put("Toronto Raptors", "猛龙");
	}
}
