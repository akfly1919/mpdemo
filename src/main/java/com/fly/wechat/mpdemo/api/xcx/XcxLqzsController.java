package com.fly.wechat.mpdemo.api.xcx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fly.wechat.mpdemo.api.BaseController;

@Controller
@RequestMapping("/xcx/lqzs")
public class XcxLqzsController extends BaseController{
	
	@ResponseBody
	@RequestMapping("/list.do")
	public String getUserInfo() throws Throwable {
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("url", "http://mp.weixin.qq.com/s?__biz=MzA3NTkwMDAwMg==&mid=2649601472&idx=1&sn=b559d34d14433f6cd6ec5077f626c670#rd");
		map.put("picUrl", "https://mmbiz.qlogo.cn/mmbiz/VPKUdic338ZHqkvUzVFyxjSYtqk0wzKfhOSw91zBYKtfyzwy7rLhejicVicicq6qs46QHoooSbpbuTCLVQnaEwuXyA/0?wx_fmt=jpeg");
		map.put("title", "关于篮球，关于生活");
		map.put("description", "假实现，未来提供");
		for(int i=0;i<10;i++){
			list.add(map);
		}
		return JSON.toJSONString(list);
	}
	
}
