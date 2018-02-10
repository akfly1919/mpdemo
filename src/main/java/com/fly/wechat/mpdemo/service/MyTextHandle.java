package com.fly.wechat.mpdemo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fly.wechat.mpdemo.api.GrawNba;
import com.fly.wechat.mpdemo.api.Sreach;
import com.fly.wechat.mpdemo.common.BeanUtil;

public class MyTextHandle  implements Handle{

	public String handle(Map<String, String> srcMap) throws Exception {
		String msg=srcMap.get("Content");
		if(msg.startsWith("地址")){
			return onlineNbaString(srcMap);
		}
		Map<String, String> retMap=new HashMap<String,String>();
		retMap = Sreach.queryIndex(srcMap.get("Content"));
		retMap.put("ToUserName", srcMap.get("FromUserName"));
		retMap.put("FromUserName", srcMap.get("ToUserName"));
		return BeanUtil.map2xml(retMap).replaceAll("</item>]]>", "</item>").replaceAll("<!\\[CDATA\\[<item>",
				"<item>");
	}

	private String onlineNbaString(Map<String, String> map){
		GrawNba gn = new GrawNba();
		Map<String, Set<String>> nbas=gn.onlineNba();
		Map<String, String> baseMap=new HashMap<String,String>();
		baseMap.put("CreateTime", System.currentTimeMillis()+"");
		baseMap.put("MsgType", "text");
		baseMap.put("Content", nbas.toString());
		baseMap.put("ToUserName", map.get("FromUserName"));
		baseMap.put("FromUserName", map.get("ToUserName"));
		return BeanUtil.map2xml(baseMap);
	} 
}
