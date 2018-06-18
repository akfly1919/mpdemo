package com.fly.wechat.mpdemo.api.xcx;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.common.DateUtil;
import com.fly.wechat.mpdemo.common.RandomStringUtils;
import com.fly.wechat.mpdemo.match.dao.GameMapper;
import com.fly.wechat.mpdemo.match.dao.MatchMapper;
import com.fly.wechat.mpdemo.match.dao.PlayerMapper;
import com.fly.wechat.mpdemo.match.dao.TeamMapper;
import com.fly.wechat.mpdemo.match.model.Game;
import com.fly.wechat.mpdemo.match.model.Match;
import com.fly.wechat.mpdemo.match.model.Player;
import com.fly.wechat.mpdemo.match.model.Team;
import com.fly.wechat.mpdemo.match.util.CommonUtils;
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
	@Resource
	private PlayerMapper playerMapper;
	@Resource
	private GameMapper gameMapper;
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
		Match re=new Match();
		re.setToken(match.getToken());
		re=matchMapper.selectByMatch(re).get(0);
		Map<String,String> map=success();
		int num=match.getNum();
		int groupNum=match.getGroupNum();
		String group="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int count=num/groupNum;
		List<Team> teams=new ArrayList<Team>();
		//生成球队
		for(int i=1;i<=num;i++){
			Team t=new Team();
			//生成id
			t.setOpenid(match.getOpenid());
			t.setToken(RandomStringUtils.generateString(6));
			t.setName(group.charAt(i/count)+""+(i>count?i-count:i));
			teams.add(t);
			teamMapper.insert(t);
		}
		for(int i=0;i<groupNum;i++){
			String s=group.charAt(i)+"";
			List<Game> list=null;
			if(i==(groupNum-1)){
				list=CommonUtils.shuffle(s, num-i*count, num);
			}else{
				list=CommonUtils.shuffle(s, count, num);
			}
			for(Game g:list){
				g.setMatchId(re.getId());
				g.setAid(aid);
				gameMapper.insertSelective(g);
			}
		}
		
		map.put("data", JSON.toJSONString(teams));
		return toJsonString(map);
	}
	@RequestMapping("/buildSC.do")
	//dataJson=[1|name]
	public String buildSC(String matchId,String dataJson) throws Throwable {
		JSONArray ja=JSON.parseArray(dataJson);
		for(int i=0;i<ja.size();i++){
			Team t=new Team();
			String s=ja.getString(i);
			String[] ss=s.split("|");
			t.setId(Long.valueOf(ss[0]));
			t.setName(ss[1]);
			teamMapper.updateByPrimaryKeySelective(t);
		}
		
		return toJsonString(success());
	}
	@RequestMapping("/saveSC.do")
	//dataJson=[1|2018-08-08 18:48:48]
	public String saveSC(String matchId,String dataJson) throws Throwable {
		JSONArray ja=JSON.parseArray(dataJson);
		for(int i=0;i<ja.size();i++){
			Game g=new Game();
			String s=ja.getString(i);
			String[] ss=s.split("|");
			g.setId(Long.valueOf(ss[0]));
			g.setGameTime(DateUtil.parseStrToDate(ss[2], DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
			gameMapper.updateByPrimaryKeySelective(g);
		}
		return toJsonString(success());
	}
	
	@RequestMapping("/updA1.do")
	//dataJson=[A|1|teamId]
	public String updA1(String matchId,String dataJson) throws Throwable {
		JSONArray ja=JSON.parseArray(dataJson);
		for(int i=0;i<ja.size();i++){
			Game g=new Game();
			String s=ja.getString(i);
			String[] ss=s.split("|");
			g.setId(Long.valueOf(ss[0]));
			gameMapper.updateByPrimaryKeySelective(g);
		}
		return toJsonString(success());
	}
	@RequestMapping("/updA1k.do")
	//dataJson=[A|1|teamId]
	public String updA1k(String matchId,String dataJson) throws Throwable {
		JSONArray ja=JSON.parseArray(dataJson);
		for(int i=0;i<ja.size();i++){
			Game g=new Game();
			String s=ja.getString(i);
			String[] ss=s.split("|");
			g.setId(Long.valueOf(ss[0]));
			gameMapper.updateByPrimaryKeySelective(g);
		}
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
		Map<String,String> map=success();
		return toJsonString(map);
	}
	
	@ResponseBody
	@RequestMapping("/updPlayer.do")
	public String updPlayer(@ModelAttribute Player player) throws Throwable {
		log.info("updPlayer args:"+player);
		Player p=new Player();
		p.setOpenid(player.getOpenid());
		List<Player> players=playerMapper.selectByPlayer(p);
		if(players!=null){
			if(players.size()==0){
				playerMapper.insertSelective(player);
			}else{
				playerMapper.updateByPrimaryKeySelective(player);
			}
		}
		List<Player> retP=playerMapper.selectByPlayer(p);
		Map<String,String> map=success();
		if(retP!=null&&retP.size()==1){
			map.put("data", JSON.toJSONString(retP.get(0)));
		}
		return toJsonString(map);
	}
	@ResponseBody
	@RequestMapping("/upload.do")
	public String upload(HttpServletRequest request) throws Throwable {
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
               request.getSession().getServletContext());
       //检查form中是否有enctype="multipart/form-data"
       List<String> images=new ArrayList<String>();
       if(multipartResolver.isMultipart(request)){
           //将request变成多部分request
           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
          //获取multiRequest 中所有的文件名
           Iterator iter=multiRequest.getFileNames();
           int i=0;
           String n1=System.currentTimeMillis()+"";
           while(iter.hasNext()){
        	   String fileName=""; 
               //一次遍历所有文件
               MultipartFile file=multiRequest.getFile(iter.next().toString());
               if(file!=null){
            	   fileName=n1+i+file.getOriginalFilename();
                   String path="/home/images/"+fileName;
                   file.transferTo(new File(path));
               }
               images.add("https://fei.coucang.com/"+fileName);
           }
       }
		return JSON.toJSONString(images);
	}
	
}
