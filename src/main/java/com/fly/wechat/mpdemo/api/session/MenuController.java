package com.fly.wechat.mpdemo.api.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.config.MchInfo;
import com.fly.wechat.mpdemo.model.Button;
import com.fly.wechat.mpdemo.model.Matchrule;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{
	
	public String GETMENU_URL="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	public String CREATEMENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	public String CREATEPMENU_URL="https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
	
	public String DELETEMENU_URL="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	public String GETCURRENTMENU_URL="https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";
	/**
	 * 自定义菜单查询接口
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/getMenu.do")
	public String getMenu() throws Throwable {
		return httpGet(GETMENU_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), "", d_timeout);
	}
	/**
	 * 自定义菜单创建接口
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/createMenu.do")
	public String createMenu() throws Throwable {
		List<Button> list=new ArrayList<Button>();
		List<Button> subList=new ArrayList<Button>();
		Button b1=new Button("click","中国大飞","b1","","",null);
		subList.add(new Button("view","百度","b21","http://www.baidu.com/","",null));
		subList.add(new Button("view","QQ","b22","http://www.qq.com/","",null));
		subList.add(new Button("view","网易","b23","http://www.163.com/","",null));
		Button b2=new Button("click","中国二飞","b2","","",subList);
		Button b3=new Button("click","中国三飞","b3","","",null);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("button", list);
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(CREATEMENU_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	/**
	 * 自定义菜单删除接口
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/deleteMenu.do")
	public String deleteMenu() throws Throwable {
		return httpGet(DELETEMENU_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), "", d_timeout);
	}
	/**
	 * 获取自定义菜单配置接口
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/getCurrentMenu.do")
	public String getCurrentMenu() throws Throwable {
		return httpGet(GETCURRENTMENU_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), "", d_timeout);
	}
	
	/**
	 * 自定义菜单创建接口
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/createPMenu.do")
	public String createPMenu() throws Throwable {
		List<Button> list=new ArrayList<Button>();
		List<Button> subList=new ArrayList<Button>();
		Button b1=new Button("click","中国大飞","b1","","",null);
		subList.add(new Button("view","百度","b21","http://www.baidu.com/","",null));
		subList.add(new Button("view","QQ","b22","http://www.qq.com/","",null));
		subList.add(new Button("view","网易","b23","http://www.163.com/","",null));
		Button b2=new Button("click","中国二飞","b2","","",subList);
		Button b3=new Button("click","中国三飞","b3","","",null);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("button", list);
		map.put("matchrule", new Matchrule("100", "", "1", "", "", "", "zh_CN"));
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(CREATEMENU_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	
	
	public static void main(String[] args) throws Throwable {
		MenuController mc=new MenuController();
		mc.createMenu();
//		mc.getMenu();
//		mc.deleteMenu();
//		mc.getCurrentMenu();
//		mc.createPMenu();
	}
	
}
