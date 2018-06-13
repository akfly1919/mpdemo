package com.fly.wechat.mpdemo.api.xcx;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.stat.Match;
import com.fly.wechat.mpdemo.stat.Player;
import com.fly.wechat.mpdemo.stat.Team;

@Controller
@RequestMapping("/xcx")
public class XcxController extends BaseController{
	String APPID="wx0a1b3ce5d441c49f";
	String SECRET="a5351b4a745535eb379b0bd47b6c0f6e";
	String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
	
	@ResponseBody
	@RequestMapping("/addMatch.do")
	public String addMatch(@ModelAttribute Match match) throws Throwable {
		log.info("addMatch args:"+match);
		Map<String,String> map=new HashMap<String,String>();
		return JSON.toJSONString(map);
	}
	@ResponseBody
	@RequestMapping("/updMatch.do")
	public String updMatch(@ModelAttribute Match match) throws Throwable {
		log.info("updMatch args:"+match);
		Map<String,String> map=new HashMap<String,String>();
		return JSON.toJSONString(map);
	}
	@ResponseBody
	@RequestMapping("/addTeam.do")
	public String addTeam(@ModelAttribute Team team) throws Throwable {
		log.info("addTeam args:"+team);
		Map<String,String> map=new HashMap<String,String>();
		return JSON.toJSONString(map);
	}
	@ResponseBody
	@RequestMapping("/updTeam.do")
	public String updTeam(@ModelAttribute Team team) throws Throwable {
		log.info("updTeam args:"+team);
		Map<String,String> map=new HashMap<String,String>();
		return JSON.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping("/addPlayer.do")
	public String addPlayer(@ModelAttribute Player player) throws Throwable {
		log.info("addMatch args:"+player);
		Map<String,String> map=new HashMap<String,String>();
		return JSON.toJSONString(map);
	}
	
	@ResponseBody
	@RequestMapping("/updPlayer.do")
	public String updPlayer(@ModelAttribute Player player) throws Throwable {
		log.info("updPlayer args:"+player);
		Map<String,String> map=new HashMap<String,String>();
		return JSON.toJSONString(map);
	}
	@ResponseBody
	@RequestMapping("/getUserInfo.do")
	public String getUserInfo() throws Throwable {
		Map<String,String> map=new HashMap<String,String>();
		return JSON.toJSONString(map);
	}
	
	
}
