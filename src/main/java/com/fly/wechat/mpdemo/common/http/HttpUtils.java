package com.fly.wechat.mpdemo.common.http;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.CodingErrorAction;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;

/**
 * 基于http4.4的httputils 1.整合了http和https 2.可以动态调connManager 3.灵活调整超时时间
 * 
 * @author fly
 *
 */
public class HttpUtils {

	public static final Logger log = Logger.getLogger(HttpUtils.class);

	public static RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(5000)
			.setConnectTimeout(5000).setConnectionRequestTimeout(5000).build();

	public static ConnectionConfig defaultConnectionConfig = ConnectionConfig.custom()
			.setMalformedInputAction(CodingErrorAction.IGNORE).setUnmappableInputAction(CodingErrorAction.IGNORE)
			.setCharset(Consts.UTF_8).build();

	public static PoolingHttpClientConnectionManager poolConnManager = null;

	public static CloseableHttpClient getHttpClient() {
		return getHttpClient(0, false);
	}

	public static CloseableHttpClient getHttpClient(int timeout) {
		return getHttpClient(timeout, false);
	}

	public static CloseableHttpClient getHttpClient(int timeout, boolean isSSL) {
		RequestConfig ec = null;
		if (timeout == 0) {
			ec = defaultRequestConfig;
		} else {
			ec = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout)
					.setConnectionRequestTimeout(timeout).build();
		}
		BasicHttpClientConnectionManager basicConnManager = new BasicHttpClientConnectionManager();
		basicConnManager.setConnectionConfig(defaultConnectionConfig);
		if (isSSL) {
			X509TrustManager xtm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

			};

			try {
				SSLContext sslContext = SSLContext.getInstance("TLSv1");
				sslContext.init(null, new TrustManager[] { xtm }, null);
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
				return HttpClients.custom().setConnectionManager(basicConnManager).setDefaultRequestConfig(ec)
						.setSSLSocketFactory(sslsf).build();

			} catch (Exception e) {
				log.error("getClients", e);
			}
		}
		return HttpClients.custom().setConnectionManager(basicConnManager).setDefaultRequestConfig(ec).build();
	}

	/**
	 * 支持get方法
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Response httpGet(String url, List<ParamEntry> params, int timeout) throws Exception {
		return httpGet(url, convertParamEntrysToString(params), timeout);
	}

	/**
	 * 支持get方法
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Response httpGet(String url, String params, int timeout) throws Exception {
		CloseableHttpClient httpClient = getHttpClient(timeout);
		Response r = null;
		try {
			String u = wrapUri(url, params);
			log.info("url:" + u);
			HttpGet httpget = new HttpGet(u);
			CloseableHttpResponse response = null;
			try {
				response = httpClient.execute(httpget);
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

		return r;
	}
	public static Response httpsGet(String url, String params, int timeout) throws Exception {
		CloseableHttpClient httpClient = getHttpClient(timeout,true);
		Response r = null;
		try {
			String u = wrapUri(url, params);
			log.info("url:" + u);
			HttpGet httpget = new HttpGet(u);
			CloseableHttpResponse response = null;
			try {
				response = httpClient.execute(httpget);
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

		return r;
	}

	/**
	 * 支持post方法
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Response httpPost(String url, String params, int timeout) throws Exception {

		CloseableHttpClient httpClient = getHttpClient(timeout);
		Response r = null;
		CloseableHttpResponse response = null;
		try {
			log.info("url:" + url);
			HttpPost httpPost = new HttpPost(url);
			try {
				httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
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

		return r;
	}

	/**
	 * 支持post方法
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Response httpPostFile(String url, String name, File file, ContentType contentType, int timeout)
			throws Exception {

		CloseableHttpClient httpClient = getHttpClient(timeout);
		Response r = null;
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(url);
			try {
				MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
				multipartEntityBuilder.addBinaryBody(name, file);
				HttpEntity httpEntity = multipartEntityBuilder.build();
				httpPost.setEntity(httpEntity);
				httpPost.addHeader("content-type", contentType.toString());
				httpPost.addHeader("content_disposition", "attachment;filename=" + file.getName());
				httpPost.addHeader("filename", file.getName());
				httpPost.addHeader("filelength", Long.toString(file.length()));
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

		return r;
	}

	/**
	 * 支持post方法
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Response httpPostHeader(String url, String params, int timeout) throws Exception {

		CloseableHttpClient httpClient = getHttpClient(timeout);
		Response r = null;
		CloseableHttpResponse response = null;
		try {
			log.info("url:" + url);
			HttpPost httpPost = new HttpPost(url);
			try {
				httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
				httpPost.setEntity(new StringEntity(params));
				response = httpClient.execute(httpPost);
				r = new Response();
				r.setStatusCode(response.getStatusLine().getStatusCode());
				if (response.getStatusLine().getStatusCode() == 200) {
					r.setResponseString(JSONArray.toJSONString(response.getAllHeaders()));
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

		return r;
	}

	public static String wrapUri(String url, String params) {
		String u = "";
		if (params == null || params.length() == 0) {
			return url;
		}
		if (url.indexOf("?") == -1) {
			u = url + "?" + params;
		} else if (url.indexOf("?") == (url.length() - 1)) {
			u = url + params;
		} else {
			u = url + "&" + params;
		}
		return u;
	}

	public static String wrapUri(String url, List<ParamEntry> params) throws UnsupportedEncodingException {
		if (params == null) {
			return wrapUri(url, "");
		}
		return wrapUri(url, convertParamEntrysToString(params));
	}

	public static String convertParamEntrysToString(List<ParamEntry> postParams) throws UnsupportedEncodingException {
		String result = "";
		if (postParams.size() > 0) {
			StringBuffer sb = new StringBuffer();
			for (ParamEntry pp : postParams) {
				sb.append(pp.getKey()).append("=").append(URLEncoder.encode(pp.getValue(), "UTF-8")).append("&");
			}
			result = sb.toString();
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}

}
