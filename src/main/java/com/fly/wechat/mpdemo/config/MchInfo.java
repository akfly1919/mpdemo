package com.fly.wechat.mpdemo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.fly.wechat.mpdemo.api.session.BaseSupportController;
import com.fly.wechat.mpdemo.common.BeanUtil;
import com.fly.wechat.mpdemo.common.http.HttpUtils;
import com.fly.wechat.mpdemo.common.http.Response;
import com.fly.wechat.mpdemo.common.secure.SignUtils;

public class MchInfo {
	
	public static  Logger log = Logger.getLogger(MchInfo.class);
	
	public static final String APPID = "wxb3a1526c855619fe";

	public static final String APPSECRET = "f20d53c04c641840ad67ced125ece31f";
	
	public static  Map<String,String> errcodeMap = new HashMap<String, String>();

	private static String ACCESS_TOKEN = "10_m0685enwvcsD6AWdhXMdDF_bYwkhm4c89mPIXJlDYDciMjFVEcsJ0WliYSCcV77bmDpATrSVmYVCEjue-2U9Q3F2JuBM3BhPJD52wuRcNrtxuMzspHGdzjUKR_QsEO9lYEFLKY6CozGLTsWxUXOcAHACFW";

	static {
		if (ACCESS_TOKEN == null || ACCESS_TOKEN.length() == 0) {
			try {
				Map<String, String> map = new HashMap<String, String>();
				map.put("appid", MchInfo.APPID);
				map.put("secret", MchInfo.APPSECRET);
				map.put("grant_type", "client_credential");
				Response response = HttpUtils.httpGet(BaseSupportController.GETACCESSTOKEN_URL,
						SignUtils.createLinkString(map), 5000);
				if (response != null && response.getStatusCode() == 200) {
					Map<String, String> rtn = BeanUtil.json2Map(response.getResponseString());
					ACCESS_TOKEN = map == null ? "" : rtn.get("access_token");
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		load();
	}

	public static String getAccessToken() {
		return ACCESS_TOKEN;
	}

	public static void setAccessToken(String atk) {
		ACCESS_TOKEN = atk;
	}
	
	private static void load(){
		Scanner s=null;
		try {
			s = new Scanner(MchInfo.class.getClassLoader().getResourceAsStream("errcodeMap.txt"));
			while(s.hasNext()){
				String src=s.nextLine();
				String[] kv=src.split(" ");
				errcodeMap.put(kv[0], kv[1]);
			}
			log.info("load---errcodeMap:"+errcodeMap.size());
		} catch (Throwable t) {
			log.error(t);
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}
	
	public static String coverErrorCode(String key){
		return errcodeMap.get(key);
	}
	
}
