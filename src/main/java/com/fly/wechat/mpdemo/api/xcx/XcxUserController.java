package com.fly.wechat.mpdemo.api.xcx;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.common.http.HttpUtils;
import com.fly.wechat.mpdemo.common.http.Response;
import com.fly.wechat.mpdemo.match.dao.PlayerMapper;
import com.fly.wechat.mpdemo.match.model.Player;
import com.fly.wechat.mpdemo.match.util.WXCore;

@Controller
@RequestMapping("/xcx/user")
public class XcxUserController extends BaseController {
	static String APPID = "wxc20a02533ffcc185";
	static String SECRET = "b27a9c146065d5657ad541dccc32a879";
	static String url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
	@Resource
	private PlayerMapper playerMapper;
	// static String JSCODE="071AXB2P0K6f4c2Khu2P01Uu2P0AXB2U";
	@ResponseBody
	@RequestMapping("/login.do")
	public String login(String jscode, String encryptedData, String iv) throws Throwable {
		// {"session_key":"8P9xDI\/dgzdmpILPT+crbg==","openid":"o7TVV4znQz3p60Ph1ssqPBJJXv50"}
		log.info("login jscode:" + jscode);
		String u = url.replaceAll("APPID", APPID).replaceAll("SECRET", SECRET).replaceAll("JSCODE", jscode);
		Response response = HttpUtils.httpsGet(u, null, 2000);
		log.info("login response:" + response.getResponseString());
		JSONObject Jobj = JSON.parseObject(response.getResponseString());
		String s = WXCore.decrypt(APPID, encryptedData, Jobj.getString("session_key"), iv);
		log.info("getUserInfo s:" + s);
		JSONObject js=JSON.parseObject(s);
		Player p=playerMapper.selectByOpenId(Jobj.getString("openid"));
		if(p==null){
			Player record=new Player();
			record.setOpenid(Jobj.getString("openid"));
			record.setPicurl(js.getString("avatarUrl"));
			record.setName(js.getString("nickName"));
			playerMapper.insertSelective(record);
		}
		return s;
	}

}
