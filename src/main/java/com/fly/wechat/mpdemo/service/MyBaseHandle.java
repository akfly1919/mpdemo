package com.fly.wechat.mpdemo.service;

import java.util.HashMap;
import java.util.Map;

import com.fly.wechat.mpdemo.common.BeanUtil;

public class MyBaseHandle {

	public String baseString(Map<String, String> map){
		Map<String, String> baseMap=new HashMap<String,String>();
		baseMap.put("CreateTime", System.currentTimeMillis()+"");
		baseMap.put("MsgType", "text");
		baseMap.put("Content", "正在调试");
		baseMap.put("ToUserName", map.get("FromUserName"));
		baseMap.put("FromUserName", map.get("ToUserName"));
		return BeanUtil.map2xml(baseMap);
	} 
}
