package com.fly.wechat.mpdemo.api;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fly.wechat.mpdemo.model.AppMsg;

@Controller
public class SreachController {
	public static final Logger log = Logger.getLogger(SreachController.class);
	@ResponseBody
	@RequestMapping(value = "/createIndex.do")
	public String createIndex(int count) {
		Sreach s = new Sreach();
		for (int i = 0; i < count; i = i + 5) {
			List<AppMsg> list;
			try {
				list = s.grawList(i, 5);
				s.createIndex(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "ok";
	}
}
