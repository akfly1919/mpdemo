package com.fly.wechat.mpdemo.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.wechat.mpdemo.common.BeanUtil;

/**
 *注册到微信，并监听分发事件
 *
 */
@Controller
public class DispatchController extends BaseController{
	@ResponseBody
	@RequestMapping(value = "/dispatch.do")
	public String dispatch(HttpServletRequest request, HttpServletResponse response) {
		boolean isGet = request.getMethod().toLowerCase().equals("get");  
		if(isGet){
			return access(request, response);
		}else{
			try {
				return accessMessage(request, response);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	private String accessMessage(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		String xml = IOUtils.toString(request.getInputStream());
		Map<String,String> map=BeanUtil.xml2Map(xml);
		log.info("accessMessage:"+map);
		return "";
	}
}
