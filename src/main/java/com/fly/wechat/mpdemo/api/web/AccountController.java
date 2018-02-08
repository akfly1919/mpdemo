package com.fly.wechat.mpdemo.api.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fly.wechat.mpdemo.api.BaseController;
import com.fly.wechat.mpdemo.config.MchInfo;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
	
	public static String CREATEQRCODE_URL="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	
	public static String SHOWQRCODE_URL="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	public static String SHORTURL="https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
	
	/**
	 * 生成带参数的二维码
	 *{"ticket":"gQFt8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2xEdHVmeTNsUWpvNzZ6RXc0QlB2AAIE46gdWAMEAAAAAA==",
	 *"url":"http:\/\/weixin.qq.com\/q\/lDtufy3lQjo76zEw4BPv"} errMsg:null

	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/createQrcode.do")
	public String createQrcode() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("expire_seconds", "3000");
		map.put("action_name", "QR_LIMIT_STR_SCENE");//QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值
		Map<String,String> subMap=new HashMap<String,String>();
		Map<String, Object> map1 = new HashMap<String, Object>();
//		subMap.put("scene_id", "3000");//场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
		subMap.put("scene_str", "dafei");//场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
		map1.put("scene", subMap);
		map.put("action_info", map1);//二维码详细信息
		
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(CREATEQRCODE_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	/**
	 * 通过ticket换取二维码
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/showQrcode.do")
	public String showqrcode() throws Throwable {
		return httpPostHeader(SHOWQRCODE_URL.replace("TICKET", "gQFt8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2xEdHVmeTNsUWpvNzZ6RXc0QlB2AAIE46gdWAMEAAAAAA=="), "", d_timeout);
	}
	
	/**
	 * 长链接转短链接接口
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/shorturl.do")
	public String shorturl() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("action", "long2short");//此处填long2short，代表长链接转短链接	
		map.put("long_url", "http://joke.uhdog.com/");//需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
		
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(SHORTURL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	

	public static void main(String[] args) throws Throwable {
		AccountController ac = new AccountController();
//		ac.createQrcode();
//		System.out.println(BeanUtil.formatJson(ac.showqrcode()));
		ac.shorturl();
	}
}
