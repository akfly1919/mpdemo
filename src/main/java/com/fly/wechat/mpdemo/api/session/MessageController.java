package com.fly.wechat.mpdemo.api.session;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.common.http.HttpUtils;
import com.fly.wechat.mpdemo.common.http.Response;
import com.fly.wechat.mpdemo.common.secure.SignUtils;
import com.fly.wechat.mpdemo.config.MchInfo;

@Controller
@RequestMapping("/message")
public class MessageController extends BaseController{
	/**
	 * 发送客服消息
	 */
	public static final String CUSTOMSEND_URL="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	/**
	 * 获取自动回复数据
	 */
	public static final String GET_CURRENT_AUTOREPLY_INFO_URL="https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN";
	
	@ResponseBody
	@RequestMapping("/customsend.do")
	public String customsend() throws Throwable {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("touser", "oK6W9wNQ9zyR5uwhLkNQ61i0ak08");
		map.put("msgtype", "text");
		Map<String,String> subMap=new HashMap<String,String>();
		subMap.put("content", "helloworld");
		map.put("text", subMap);
		return httpPost(CUSTOMSEND_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), JSON.toJSONString(map), d_timeout);
	}
	
	@ResponseBody
	@RequestMapping("/getAutoreply.do")
	public String getAutoreply() throws Throwable {
		return httpPost(GET_CURRENT_AUTOREPLY_INFO_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), "", d_timeout);
	}
	public static void main(String[] args) throws Throwable{
		MessageController mc=new MessageController();
		mc.customsend();
		mc.getAutoreply();
	}
}
