package com.fly.wechat.mpdemo.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import com.fly.wechat.mpdemo.common.http.HttpUtils;
import com.fly.wechat.mpdemo.common.http.Response;

public class GrawNba {
	public static final Logger log = Logger.getLogger(Sreach.class);

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
		System.out.println(html);
		// TagNode node =cleaner.clean(new
		// File("/Users/panghuiyuan/git/mpdemo/src/main/resources/2.txt"));
		TagNode node = cleaner.clean(html);
		Object[] tables = node.evaluateXPath("//a[@rel=\"nofollow\"]");
		System.out.println(tables.length);
		if (tables != null) {
			for (Object obj : tables) {
				TagNode tab = (TagNode) obj;
				String surl = tab.getAttributeByName("href");
				if (surl.startsWith("http") && !surl.startsWith("https://www.reddit.com/")
						&& !surl.startsWith("http://bilasport.me")) {
					if (set.size() < 3) {
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
				System.out.println(set);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			map.put(key,set);
		}
		System.out.println(map);
		return map;
	}

	public static void main(String[] args) throws Exception {
		// read("http://www.baidu.com/index.jsp");
	}
}
