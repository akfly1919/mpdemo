package com.fly.wechat.mpdemo.api.xcx;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
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
import com.fly.wechat.mpdemo.match.dao.MatchTeamMapper;
import com.fly.wechat.mpdemo.match.dao.PlayerMapper;
import com.fly.wechat.mpdemo.match.dao.TeamMapper;
import com.fly.wechat.mpdemo.match.dao.TeamPlayerMapper;
import com.fly.wechat.mpdemo.match.model.Game;
import com.fly.wechat.mpdemo.match.model.Match;
import com.fly.wechat.mpdemo.match.model.MatchTeam;
import com.fly.wechat.mpdemo.match.model.Player;
import com.fly.wechat.mpdemo.match.model.Team;
import com.fly.wechat.mpdemo.match.model.TeamPlayer;
import com.fly.wechat.mpdemo.match.util.IdUtil;
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
	private MatchTeamMapper matchTeamMapper;
	@Resource
	private TeamMapper teamMapper;
	@Resource
	private PlayerMapper playerMapper;
	@Resource
	private GameMapper gameMapper;
	@Resource
	private TeamPlayerMapper teamPlayerMapper;
	@Autowired
	private ThreadPoolTaskExecutor myPool;
	@ResponseBody
	@RequestMapping("/addMatch.do")
	public String addMatch(@ModelAttribute Match match,String begDate,String endDate) throws Throwable {
		log.info("addMatch args:"+match);
		//生成赛事
		if(match.getOpenid()==null||StringUtils.isNullOrEmpty(match.getName())){
			return JSON.toJSONString(map("301","openid is null"));
		}
		if(match.getNum()==null||match.getNum()>64){
			return JSON.toJSONString(map("302","num 最多 64支"));
		}
		match.setStatus("0");
		match.setCreateTime(new Date());
		match.setToken(WXCore.buildToken());
		match.setLqType(new Byte("0"));
		match.setBegtime(DateUtil.parseStrToDate(begDate, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
		match.setEndtime(DateUtil.parseStrToDate(endDate, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
		String matchId=IdUtil.genId("mt");
		match.setMatchId(matchId);
		match.setCreateTime(new Date());
		matchMapper.insertSelective(match);
		Map<String,String> map=success();
		//生成分组和球队
		int num=match.getNum();
		int groupNum=match.getGroupnum();
		String group="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final List<MatchTeam> mts=new ArrayList<MatchTeam>();
		//生成球队
		String teamId=IdUtil.genId("");
		for(int i=1;i<=num;i++){
			Team t=new Team();
			//生成id
			t.setTeamId(teamId+i+"t");
			t.setOpenid(match.getOpenid());
			t.setToken(RandomStringUtils.generateString(6));
			t.setCreateTime(new Date());
			teamMapper.insertSelective(t);
			MatchTeam mt=new MatchTeam();
			mt.setTeamId(t.getTeamId());
			mt.setMatchId(matchId);
			mt.setGroupName(group.charAt((i-1)%groupNum)+"");
			matchTeamMapper.insertSelective(mt);
			mts.add(mt);
		}
		//生成赛程
		myPool.execute(new Runnable(){
			@Override
			public void run() {
				long begTime=System.currentTimeMillis();
				log.info("buildGame :"+begTime);
				Map<String,List<MatchTeam>> mmt=new HashMap<String,List<MatchTeam>>();
				for(MatchTeam mt:mts){
					builder(mmt, mt);
				}
				for(String key:mmt.keySet()){
					List<Game> games=shuffle(key, mmt.get(key));
					for(Game g:games){
						gameMapper.insertSelective(g);
					}
				}
				log.info("buildGame :"+(System.currentTimeMillis()-begTime));
			}
		});
		map.put("data", JSON.toJSONString(mts));
		return toJsonString(map);
	}
	private void builder(Map<String,List<MatchTeam>> mmt,MatchTeam mt){
		List<MatchTeam> list=null;
		if(mmt.containsKey(mt.getGroupName())){
			list=mmt.get(mt.getGroupName());
		}else{
			list=new ArrayList<MatchTeam>();
		}
		list.add(mt);
		mmt.put(mt.getGroupName(), list);
	}
	private  List<Game> shuffle(String group,List<MatchTeam> mt) {
		List<Game> games = new ArrayList<Game>();
		int num=mt.size();
		String gid=IdUtil.genId("");
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (num % 2 == 0) {
			for (int i = 0; i < num; i++) {
				list.add(i + 1);
			}
		} else {
			for (int i = 0; i < num; i++) {
				list.add(i + 1);
			}
			list.add(0);
		}
		for (int i = 1; i <= num - 1; i++) {
			for (int j = 0; j < list.size() / 2; j++) {
				int a = list.get(j);
				int b = list.get(list.size() - 1 - j);
				if(a!=0&&b!=0){
					Game g=new Game();
					g.setGameId(gid+i+""+j+"g");
					g.setAid(mt.get(a-1).getTeamId());
					g.setBid(mt.get(b-1).getTeamId());
					g.setMatchId(mt.get(a-1).getMatchId());
					g.setName(group+"|"+i);
					games.add(g);
				}
			}
			int temp = list.pollLast(); // 获取最后一个元素
			list.add(1, temp);// 将最后一个元素放在List的第二个位置
		}
		return games;
	}
	@RequestMapping("/buildSC.do")
	@ResponseBody
	//dataJson=[1|name]
	public String buildSC(String matchId,String dataJson) throws Throwable {
		JSONArray ja=JSON.parseArray(dataJson);
		for(int i=0;i<ja.size();i++){
			Team t=new Team();
			String s=ja.getString(i);
			String[] ss=s.split("\\|");
			t.setTeamId(ss[0]);
			t.setName(ss[1]);
			int row=teamMapper.updateByTeamIdSelective(t);
			log.info("row:"+row);
		}
		Game g=new Game();
		g.setMatchId(matchId);
		List<Game> games=gameMapper.selectByGame(g);
		List<Team> teams=teamMapper.selectByMatchId(matchId);
		Map<String,Team> maps=new HashMap<String,Team>();
		for(Team t:teams){
			maps.put(t.getTeamId(), t);
		}
		List<Map<String,String>> lists=new ArrayList<Map<String,String>>();
		for(Game gg:games){
			Map<String,String> map=new HashMap<String,String>();
			map.put("gameId", gg.getId()+"");
			map.put("name", gg.getName()+"");
			map.put("gameName", maps.get(gg.getAid()).getName()+"VS"+maps.get(gg.getBid()).getName());
			lists.add(map);
		}
		Map<String,String> map=success();
		map.put("data", JSON.toJSONString(lists));
		return toJsonString(map);
	}
	@RequestMapping("/saveSC.do")
	@ResponseBody
	//dataJson=[1|2018-08-08 18:48:48]
	public String saveSC(String matchId,String dataJson) throws Throwable {
		JSONArray ja=JSON.parseArray(dataJson);
		for(int i=0;i<ja.size();i++){
			Game g=new Game();
			String s=ja.getString(i);
			String[] ss=s.split("\\|");
			g.setGameId(ss[0]);;
			g.setGameTime(DateUtil.parseStrToDate(ss[1], DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
			gameMapper.updateByGameIdSelective(g);
		}
		return toJsonString(success());
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
	@ResponseBody
	@RequestMapping("/faMatch.do")
	public String faMatch(@ModelAttribute Match match,String begDate,String endDate,String aId) throws Throwable {
		log.info("faMatch args:"+match);
		//生成赛事
		if(match.getOpenid()==null||StringUtils.isNullOrEmpty(match.getName())){
			return JSON.toJSONString(map("301","openid is null"));
		}
		match.setStatus("0");
		match.setCreateTime(new Date());
		match.setToken(WXCore.buildToken());
		match.setLqType(new Byte("1"));
		match.setBegtime(DateUtil.parseStrToDate(begDate, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
		match.setEndtime(DateUtil.parseStrToDate(endDate, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
		String matchId=IdUtil.genId("mt");
		match.setMatchId(matchId);
		match.setNum(2);
		match.setGroupnum(1);
		match.setCreateTime(new Date());
		matchMapper.insertSelective(match);
		Game g=new Game();
		g.setGameId(IdUtil.genId("g"));
		g.setMatchId(matchId);
		g.setAid(aId);
		gameMapper.insertSelective(g);
		return toJsonString(success());
	}
	@ResponseBody
	@RequestMapping("/selMatch.do")
	public String selMatch(@ModelAttribute Match match) throws Throwable {
		log.info("selMatch args:"+match);
		//生成赛事
		if(match.getOpenid()==null||StringUtils.isNullOrEmpty(match.getName())){
			return JSON.toJSONString(map("301","openid is null"));
		}
		List<Match> list=matchMapper.selectByMatch(match);
		Map<String,String> map=success();
		map.put("data", JSON.toJSONString(list));
		return toJsonString(map);
	}
	
	@ResponseBody
	@RequestMapping("/updMatch.do")
	public String updMatch(@ModelAttribute Match match,String begDate,String endDate) throws Throwable {
		log.info("updMatch args:"+match);
		if(match.getOpenid()==null){
			return JSON.toJSONString(map("301","openid is null"));
		}
		match.setBegtime(DateUtil.parseStrToDate(begDate, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
		match.setEndtime(DateUtil.parseStrToDate(endDate, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
		matchMapper.updateByPrimaryKeySelective(match);
		Map<String,String> map=success();
		return toJsonString(map);
	}
	@ResponseBody
	@RequestMapping("/addTeam.do")
	public String addTeam(@ModelAttribute Team team) throws Throwable {
		log.info("addTeam args:"+team);
		String teamId=IdUtil.genId("tm");
		team.setTeamId(teamId);
		team.setToken(WXCore.buildToken());
		team.setStatus("0");
		teamMapper.insertSelective(team);
		Map<String,String> map=success();
		return toJsonString(map);
	}
	@ResponseBody
	@RequestMapping("/updTeam.do")
	public String updTeam(@ModelAttribute Team team) throws Throwable {
		log.info("updTeam args:"+team);
		teamMapper.updateByPrimaryKeySelective(team);
		Map<String,String> map=success();
		return toJsonString(map);
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
	@RequestMapping("/updTeamPlayer.do")
	public String updTeamPlayer(@ModelAttribute TeamPlayer teamPlayer) throws Throwable {
		log.info("updTeamPlayer args:"+teamPlayer);
		teamPlayerMapper.updateByPrimaryKeySelective(teamPlayer);
		Map<String,String> map=success();
		return toJsonString(map);
	}
	@ResponseBody
	@RequestMapping("/selTeamPlayer.do")
	public String selTeamPlayer(String teamId) throws Throwable {
		TeamPlayer tp=new TeamPlayer();
		tp.setTeamId(teamId);
		List<TeamPlayer> tps=teamPlayerMapper.selectByTeamPlayer(tp);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for(TeamPlayer t:tps){
			if(t.getStatus()==0){
				Player p=playerMapper.selectByOpenId(t.getPlayerId());
				if(p!=null){
					Map<String,String> map=new HashMap<String,String>();
					map.put("id", t.getId()+"");
					map.put("num", t.getNum());
					map.put("name", p.getName());
					map.put("picUrl", p.getPicurl());
					list.add(map);
				}
			}
		}
		log.info("selTeamPlayer args:"+list);
		Map<String,String> map=success();
		map.put("data", JSON.toJSONString(list));
		return toJsonString(map);
	}
	
	@ResponseBody
	@RequestMapping("/istTeam.do")
	public String istTeam(String token,String openId) throws Throwable {
		Team team=new Team();
		team.setToken(token);
		log.info("istTeam args:"+team);
		List<Team> list=teamMapper.selectByTeam(team);
		if(list!=null&&list.size()==1){
			Team t=list.get(0);
			TeamPlayer tp=new TeamPlayer();
			tp.setTeamId(t.getTeamId());
			tp.setPlayerId(openId);
			tp.setStatus(0);
			teamPlayerMapper.insertSelective(tp);
		}
		Map<String,String> map=success();
		map.put("data", JSON.toJSONString(list));
		return toJsonString(map);
	}
}
