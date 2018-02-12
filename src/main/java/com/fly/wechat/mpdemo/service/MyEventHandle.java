package com.fly.wechat.mpdemo.service;

import java.util.HashMap;
import java.util.Map;

import com.fly.wechat.mpdemo.common.BeanUtil;

public class MyEventHandle  extends MyBaseHandle implements Handle{

	public String handle(Map<String, String> srcMap) throws Exception {
		Map<String, String> baseMap=new HashMap<String,String>();
		if("subscribe".equals(srcMap.get("Event"))){
			baseMap.put("Content", "关注我是正确的选择,欢迎对话提问，将自动从历史文章中搜索匹配您问题的最佳答案");
		}else if("unsubscribe".equals(srcMap.get("Event"))){
			baseMap.put("Content", "一千个伤心的理由，你给我一个解释");
		}
		baseMap.put("CreateTime", System.currentTimeMillis()+"");
		baseMap.put("MsgType", "text");
		baseMap.put("ToUserName", srcMap.get("FromUserName"));
		baseMap.put("FromUserName", srcMap.get("ToUserName"));
		return BeanUtil.map2xml(baseMap);
	}

}
