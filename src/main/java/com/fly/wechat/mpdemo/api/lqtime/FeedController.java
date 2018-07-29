package com.fly.wechat.mpdemo.api.lqtime;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class FeedController {
	public static final Logger log = Logger.getLogger(FeedController.class);
	@ResponseBody
	@RequestMapping(value = "/feed.do")
	public String createIndex(int beg) {
		List<FeedModel> fms=new ArrayList<FeedModel>();
		FeedModel fm=new FeedModel();
		fm.setDay("07-23");
		fm.setYear("2018");
		fm.setTime("23:37");
		List<String> newsTags=new ArrayList<String>();
		newsTags.add("NBA");
		newsTags.add("勇士");
		fm.setNewsTags(newsTags);
		fm.setSource("腾讯体育");
		fm.setContext("ESPN实力榜：勇士领衔火箭第三 湖人位列前十");
		List<String> images=new ArrayList<String>();
		images.add("http://img1.gtimg.com/sports/pics/hv1/178/165/2285/148624378.jpg");
		fm.setImages(images);
		fms.add(fm);
		return JSON.toJSONString(fms);
	}
}
