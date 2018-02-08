package com.fly.wechat.mpdemo.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.config.MchInfo;

@Controller
@RequestMapping("/web")
public class WebController extends BaseController{
	
	public static String SNSAPI_USERINFO="snsapi_userinfo";
	
	public static String SNSAPI_BASE="snsapi_base";

	public static String OAUTH2_URL="https://open.weixin.qq.com/connect/oauth2/authorize?"
			+ "appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	
	public static String OAUTH2_ACCESSTOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	
	public static String OAUTH2_REFRESHACCESSTOKEN_URL="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	
	public static String OAUTH2_USERINFO_URL="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	/**
	 * 用户同意授权，获取code
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/getCode.do")
	public String getCode() throws Throwable {
		String url=OAUTH2_URL.replace("APPID", MchInfo.APPID).replace("REDIRECT_URI", "http://joke.uhdog.com/")
				.replace("SCOPE", SNSAPI_USERINFO).replace("STATE", "dafei");
		log.info(url);
		return url;
	}
	
	
	/**
	 * 通过code换取网页授权access_token
	 * {"access_token":"9WCOltfk1LGLLK2V1EMfPMul_8cmPX4g3ki1NUQ62X5A6VvKbnVOB2vd6Pd92WnQnD314JQ3wAAH40ul08Iw7fMQWboFc46yrYyXed66ikc","expires_in":7200,
	 * "refresh_token":"ohbSO-S00W1v5E0olA5CK33hbUMZrVyZEK0m4hSPI4m6x3cXRCWcTpBK52-IWVhwyRjdYfyTeJS-23CKSyKgoSZ_BNdVozUejrzNh-k-yTs","openid":"oK6W9wNQ9zyR5uwhLkNQ61i0ak08"
	 * ,"scope":"snsapi_base"} errMsg:null
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/getAtkBycode.do")
	public String getAtkBycode() throws Throwable {
		String url=OAUTH2_ACCESSTOKEN_URL.replace("APPID", MchInfo.APPID).replace("SECRET", MchInfo.APPSECRET)
				.replace("CODE", "001FGUwv1nhgUb0N0Ezv126Rwv1FGUwx");
		log.info(url);
		return httpGet(url, "", d_timeout);
	}
	
	/**
	 * 刷新access_token
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/getFlushAtk.do")
	public String getFlushAtk() throws Throwable {
		String url=OAUTH2_REFRESHACCESSTOKEN_URL.replace("APPID", MchInfo.APPID)
				.replace("REFRESH_TOKEN", "ohbSO-S00W1v5E0olA5CK33hbUMZrVyZEK0m4hSPI4m6x3cXRCWcTpBK52-IWVhwyRjdYfyTeJS-23CKSyKgoSZ_BNdVozUejrzNh-k-yTs");
		log.info(url);
		return httpGet(url, "", d_timeout);
	}
	
	/**
	 *拉取用户信息(需scope为 snsapi_userinfo)
	 *response:{"access_token":"xE-P-50ec-e3B9KJTLtWP7BqYaCDYRbCjfg4oph6t68nos_-D9tCrS8xKUFGRnnxbnUYYSPkDvq5hzNXFsBEbqpBF2oMJiv9-yEzuzdJIss","expires_in":7200,
	 *"refresh_token":"RV1dx4s9F7DliySrle0Ar1HJPXWGDmuOPnrMyyUy02dGgBdEFO3pgYGJC3y9KKqjvAxD_Hm_LzJpcmQ2pA_uqpQYPdNzE5eiDhSO0yuzR9g"
	 *,"openid":"oK6W9wNQ9zyR5uwhLkNQ61i0ak08","scope":"snsapi_userinfo"} errMsg:null
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/getUserinfo.do")
	public String getUserinfo() throws Throwable {
		String url=OAUTH2_USERINFO_URL.replace("OPENID", "oK6W9wNQ9zyR5uwhLkNQ61i0ak08")
				.replace("ACCESS_TOKEN", "xE-P-50ec-e3B9KJTLtWP7BqYaCDYRbCjfg4oph6t68nos_-D9tCrS8xKUFGRnnxbnUYYSPkDvq5hzNXFsBEbqpBF2oMJiv9-yEzuzdJIss");
		log.info(url);
		return httpGet(url, "", d_timeout);
	}
	
	
	public static void main(String[] args) throws Throwable{
		WebController wc=new WebController();
//		wc.getCode();
//		wc.getAtkBycode();
//		wc.getFlushAtk();
		wc.getUserinfo();
	}
}
