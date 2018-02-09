package com.fly.wechat.mpdemo.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.wechat.mpdemo.common.BeanUtil;

/**
 * 注册到微信，并监听分发事件
 *
 */
@Controller
public class DispatchController extends BaseController {
	@ResponseBody
	@RequestMapping(value = "/dispatch.do")
	public String dispatch(HttpServletRequest request, HttpServletResponse response) {
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			return access(request, response);
		} else {
			try {
				return accessMessage(request, response);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	private String accessMessage(HttpServletRequest request, HttpServletResponse response) {
		try {
			String xml = IOUtils.toString(request.getInputStream());
			return handle(xml);
		} catch (IOException e) {
		}
		return "";
	}
	
	private String handle(String xml){
		Map<String, String> srcMap=new HashMap<String,String>();
		Map<String, String> retMap=new HashMap<String,String>();
		try {
			srcMap = BeanUtil.xml2Map(new String(xml.getBytes(), "UTF-8"));
			log.info("accessMessage:" + srcMap);
			retMap.put("ToUserName", srcMap.get("FromUserName"));
			retMap.put("FromUserName", srcMap.get("ToUserName"));
			if ("text".equals(srcMap.get("MsgType"))) {
				retMap = Sreach.queryIndex(srcMap.get("Content"));
				return BeanUtil.map2xml(retMap).replaceAll("</item>]]>", "</item>").replaceAll("<!\\[CDATA\\[<item>",
						"<item>");
			}
		} catch (Exception e) {
			log.error("handle error",e);
		}
		return baseString(srcMap);
	}
	
	private String baseString(Map<String, String> map){
		Map<String, String> baseMap=new HashMap<String,String>();
		baseMap.put("CreateTime", System.currentTimeMillis()+"");
		baseMap.put("MsgType", "news");
		baseMap.put("Content", "正在调试");
		baseMap.put("ToUserName", map.get("FromUserName"));
		baseMap.put("FromUserName", map.get("ToUserName"));
		return BeanUtil.map2xml(baseMap);
	} 
}
