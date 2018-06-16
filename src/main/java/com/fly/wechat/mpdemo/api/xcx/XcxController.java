package com.fly.wechat.mpdemo.api.xcx;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.match.dao.MatchMapper;
import com.fly.wechat.mpdemo.match.dao.TeamMapper;
import com.fly.wechat.mpdemo.match.model.Match;
import com.fly.wechat.mpdemo.match.model.Player;
import com.fly.wechat.mpdemo.match.model.Team;
import com.fly.wechat.mpdemo.match.util.WXCore;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/xcx/yewu")
public class XcxController extends BaseController{
	String APPID="wx0a1b3ce5d441c49f";
	String SECRET="a5351b4a745535eb379b0bd47b6c0f6e";
	String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
	@Resource
	private MatchMapper matchMapper;
	@Resource
	private TeamMapper teamMapper;
	@ResponseBody
	@RequestMapping("/addMatch.do")
	public String addMatch(@ModelAttribute Match match) throws Throwable {
		log.info("addMatch args:"+match);
		if(match.getOpenid()==null||StringUtils.isNullOrEmpty(match.getName())){
			return JSON.toJSONString(map("301","openid is null"));
		}
		match.setStatus("0");
		match.setCreateTime(new Date());
		match.setToken(WXCore.buildToken());
		matchMapper.insertSelective(match);
		return toJsonString(success());
	}
	@ResponseBody
	@RequestMapping("/updMatch.do")
	public String updMatch(@ModelAttribute Match match) throws Throwable {
		log.info("updMatch args:"+match);
		if(match.getId()==null||match.getOpenid()==null){
			return JSON.toJSONString(map("301","id or openid is null"));
		}
		matchMapper.updateByPrimaryKeySelective(match);
		return toJsonString(success());
	}
	@ResponseBody
	@RequestMapping("/selMatch.do")
	public String selMatch(@ModelAttribute Match match) throws Throwable {
		log.info("selMatch args:"+match);
		List<Match> list=matchMapper.selectByMatch(match);
		Map<String,String> map=success();
		map.put("data", JSON.toJSONString(list));
		return toJsonString(map);
	}
	@ResponseBody
	@RequestMapping("/addTeam.do")
	public String addTeam(@ModelAttribute Team team) throws Throwable {
		log.info("addTeam args:"+team);
		if(team.getOpenid()==null||StringUtils.isNullOrEmpty(team.getName())){
			return JSON.toJSONString(map("301","openid is null"));
		}
		team.setStatus("0");
		team.setCreateTime(new Date());
		team.setToken(WXCore.buildToken());
		teamMapper.insertSelective(team);
		return toJsonString(success());
	}
	@ResponseBody
	@RequestMapping("/updTeam.do")
	public String updTeam(@ModelAttribute Team team) throws Throwable {
		log.info("updTeam args:"+team);
		teamMapper.updateByPrimaryKey(team);
		return toJsonString(success());
	}
	@ResponseBody
	@RequestMapping("/selTeam.do")
	public String selTeam(@ModelAttribute Team team) throws Throwable {
		log.info("selTeam args:"+team);
		List<Team> list=teamMapper.selectByTeam(team);
		Map<String,String> map=success();
		map.put("data", JSON.toJSONString(list));
		return toJsonString(map);
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
