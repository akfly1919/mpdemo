package com.fly.wechat.mpdemo.api;

import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.entity.ContentType;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.fly.wechat.mpdemo.common.BeanUtil;
import com.fly.wechat.mpdemo.common.http.HttpUtils;
import com.fly.wechat.mpdemo.common.http.Response;
import com.fly.wechat.mpdemo.config.MchInfo;

public class BaseController {
	public Logger log = Logger.getLogger(getClass());
	
	String token = "jiayou";
	
	protected int d_timeout=5000;
	
	public Map<String,String> success(){
		Map<String,String> success=new HashMap<String,String>();
		success.put("code", "200");
		return success;
	}
	public Map<String,String> map(String code,String msg){
		Map<String,String> map=new HashMap<String,String>();
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}
	
	public String toJsonString(Object obj){
		String s=JSON.toJSONString(obj);
		log.info("toJsonString:"+s);
		return s;
	}

	String access(HttpServletRequest request, HttpServletResponse response) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		if (signature == null || timestamp == null || nonce == null || echostr == null) {
			return "signature==null||timestamp==null||nonce==null||echostr==null参数错误";
		}
		log.info("----------signature:" + signature + "--timestamp:" + timestamp + "--nonce:" + nonce
				+ "--echostr:" + echostr);
		String[] str = { timestamp, nonce, token };
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2];

		String calSign = getSHA1String(bigStr);

		log.info("-----calSign-----" + calSign);

		if (signature.equals(calSign)) {
			System.out.println("ok");
			return echostr;
		}

		return "";
	}
	
	protected String parseResponse(Response response) throws Throwable{
		if(response!=null&&response.getStatusCode()==200){
			String rtn = new String(response.getResponseString().getBytes("ISO-8859-1"), "utf-8");
			log.info("response:"+rtn+" errMsg:"+MchInfo.coverErrorCode(BeanUtil.json2Map(rtn).get("errcode")+""));
			return rtn;
		}
		return "!200 error";
	}
	
	protected String httpGet(String url, String params, int timeout) throws Throwable{
		params = new String(params.getBytes("utf-8"), "ISO-8859-1");
		Response response=HttpUtils.httpGet(url, params, timeout);
		return parseResponse(response);
	}
	
	protected String httpPost(String url, String params, int timeout) throws Throwable{
		params = new String(params.getBytes("utf-8"), "ISO-8859-1");
		Response response=HttpUtils.httpPost(url, params, timeout);
		return parseResponse(response);
	}
	
	protected String httpPostFile(String url,String name, File file,ContentType contentType, int timeout) throws Throwable{
		Response response=HttpUtils.httpPostFile(url, name, file,contentType, timeout);
		return parseResponse(response);
	}
	
	protected String httpPostHeader(String url, String params, int timeout) throws Throwable{
		params = new String(params.getBytes("utf-8"), "ISO-8859-1");
		Response response=HttpUtils.httpPostHeader(url, params, timeout);
		return response.getResponseString();
	}

	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	public static String getSHA1String(String strObj) {
		String resultString = null;
		try {
			resultString = new String(strObj);
			MessageDigest md = MessageDigest.getInstance("SHA1");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}
}
