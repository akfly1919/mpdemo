package com.fly.wechat.mpdemo.api.session;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.common.secure.SignUtils;
import com.fly.wechat.mpdemo.config.MchInfo;

@Controller
@RequestMapping("/baseSupport")
public class BaseSupportController extends BaseController{
	/**
	 * 获取token url
	 */
	public static final String GETACCESSTOKEN_URL="https://api.weixin.qq.com/cgi-bin/token";
	/**
	 * 获取微信服务器IP地址
	 */
	public static final String GETCALLBACKIP_URL="https://api.weixin.qq.com/cgi-bin/getcallbackip";
	
	
	@ResponseBody
	@RequestMapping("/getAccessToken.do")
	public String getAccessToken() throws Throwable {
		Map<String,String> map=new HashMap<String,String>();
		map.put("appid", MchInfo.APPID);
		map.put("secret", MchInfo.APPSECRET);
		map.put("grant_type", "client_credential");
		return httpGet(GETACCESSTOKEN_URL, SignUtils.createLinkString(map), d_timeout);
	}
	
	@ResponseBody
	@RequestMapping("/getcallbackip.do")
	public String getcallbackip() throws Throwable {
		Map<String,String> map=new HashMap<String,String>();
		map.put("access_token", MchInfo.getAccessToken());
		return httpGet(GETCALLBACKIP_URL, SignUtils.createLinkString(map), d_timeout);
	}
	
	public static void main(String[] args) throws Throwable{
		BaseSupportController bsc=new BaseSupportController();
		System.out.println(bsc.getAccessToken());
//		System.out.println(bsc.getcallbackip());
	}

}
