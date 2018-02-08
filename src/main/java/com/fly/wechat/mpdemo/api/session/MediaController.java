package com.fly.wechat.mpdemo.api.session;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.common.secure.SignUtils;
import com.fly.wechat.mpdemo.config.MchInfo;
import com.fly.wechat.mpdemo.model.Article;

@Controller
@RequestMapping("/media")
public class MediaController extends BaseController{
	
	public static String UPLOAD_URL="https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	
	public static String GET_URL="https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	
	public static String ADDMATERIAL_URL="https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
	
	public static String ADDNEWS_URL="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	
	public static String GETMATERIAL_URL="https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	
	public static String DELMATERIAL_URL="https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
	
	public static String UPDATEMATERIAL_URL="https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
	
	public static String GETMATERIALCOUNT_URL="https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	
	public static String BATCHGET_URL="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	
	
	/**
	 * 新增临时素材
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/upload.do")
	public String upload() throws Throwable {
		URI s=MediaController.class.getClassLoader().getResource("kobe.jpg").toURI();
		File file =new File(s);
		ContentType contentType = ContentType.create("multipart/form-data", Consts.UTF_8);
		String url=UPLOAD_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()).replace("TYPE", "image");
		log.info(url);
		return httpPostFile(url, "media", file, contentType, d_timeout);
	}
	/**
	 * 获取临时素材
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/get.do")
	public String get() throws Throwable {
		String url=GET_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken())
				.replace("MEDIA_ID", "12H99_ZEP8Dn6UkzTqcqFWsoNzzrgU_vZKRh7xbqbmxn1gJxNW9dvi3oZWD2Ghrv");
		return httpGet(url,"", d_timeout);
	}
	/**
	 * 新增永久图文
	 * yxF5_K09CFLY3--Pl1XW5mWsvsAttMBXSfEylvuFjKc
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/addnews.do")
	public String addnews() throws Throwable {
		List<Article> list=new ArrayList<Article>();
		list.add(new Article("中国大飞", "yxF5_K09CFLY3--Pl1XW5kfFv_8Kkn5GJtXQqXkfKaU", "大飞", "大飞哥", "1", "洪兴大飞哥haha", "http://joke.uhdog.com/"));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("articles", list);
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(ADDNEWS_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	/**
	 * 新增永久素材
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/addmaterial.do")
	public String addmaterial() throws Throwable {
		URI s=MediaController.class.getClassLoader().getResource("kobe.jpg").toURI();
		File file =new File(s);
		ContentType contentType = ContentType.create("multipart/form-data", Consts.UTF_8);
		String url=ADDMATERIAL_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()).replace("TYPE", "image");
		log.info(url);
		return httpPostFile(url, "media", file, contentType, d_timeout);
	}
	/**
	 * 获取永久素材
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/getmaterial.do")
	public String getmaterial() throws Throwable {
		Map<String,String> map=new HashMap<String,String>();
		map.put("media_id", "yxF5_K09CFLY3--Pl1XW5kfFv_8Kkn5GJtXQqXkfKaU");
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(GETMATERIAL_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()),postArg, d_timeout);
	}
	/**
	 * 删除永久素材
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/delmaterial.do")
	public String delmaterial() throws Throwable {
		Map<String,String> map=new HashMap<String,String>();
		map.put("media_id", "yxF5_K09CFLY3--Pl1XW5kfFv_8Kkn5GJtXQqXkfKaU");
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(DELMATERIAL_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	/**
	 * 修改永久图文素材
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/updatematerial.do")
	public String updatematerial() throws Throwable {
		Article a=new Article("中国二飞", "yxF5_K09CFLY3--Pl1XW5kfFv_8Kkn5GJtXQqXkfKaU", "大飞", "大飞哥", "1", "洪兴大飞哥haha", "http://joke.uhdog.com/");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("media_id", "yxF5_K09CFLY3--Pl1XW5mWsvsAttMBXSfEylvuFjKc");
		map.put("index", "0");
		map.put("articles", a);
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(UPDATEMATERIAL_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	/**
	 * 获取素材总数
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/getmaterialcount.do")
	public String getmaterialcount() throws Throwable {
		return httpGet(GETMATERIALCOUNT_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), "", d_timeout);
	}
	/**
	 * 获取素材列表
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/batchget.do")
	public String batchget() throws Throwable {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("type", "news");
		map.put("offset", "0");
		map.put("count", "10");
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(BATCHGET_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	public static void main(String[] args) throws Throwable{
		MediaController mc=new MediaController();
//		mc.upload();
//		mc.get();
//		mc.addmaterial();
//		mc.addnews();
//		mc.getmaterial();
//		mc.updatematerial();
//		mc.getmaterialcount();
		mc.batchget();
		
	}
}
