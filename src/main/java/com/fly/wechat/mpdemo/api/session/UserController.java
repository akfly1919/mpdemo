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
import com.fly.wechat.mpdemo.common.secure.SignUtils;
import com.fly.wechat.mpdemo.config.MchInfo;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	/**
	 * 获取用户列表
	 */
	public static final String USELIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
	/**
	 * 设置备注名
	 */
	public static final String UPDATEREMARK_URL = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
	/**
	 * 获取用户基本信息（包括UnionID机制）
	 */
	public static final String USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN";
	/**
	 * 批量获取用户基本信息
	 */
	public static final String USERINFOS_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";

	/**
	 * 创建分组
	 */
	public static final String CREATEGROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";

	/**
	 * 查询所有分组
	 */
	public static final String GROUPS_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";

	/**
	 * 查询用户所在分组
	 */
	public static final String GROUPS_ID_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";

	/**
	 * 修改分组名
	 */
	public static final String GROUPS_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";

	/**
	 * 移动用户分组
	 */
	public static final String MEMBERS_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	/**
	 * 批量移动用户分组
	 */
	public static final String MEMBERS_UPDATE_batch_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN";

	/**
	 * 删除分组
	 */
	public static final String DELETE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=ACCESS_TOKEN";

	/**
	 * 用户列表
	 * 
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/userList.do")
	public String userList() throws Throwable {
		return httpGet(USELIST_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), "", d_timeout);
	}

	/**
	 * 设置备注名
	 * 
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/updateremark.do")
	public String updateremark() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", "oK6W9wNQ9zyR5uwhLkNQ61i0ak08");
		map.put("remark", "中国大飞");
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(UPDATEREMARK_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}

	/**
	 * 获取用户基本信息（包括UnionID机制）
	 * 
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/userinfo.do")
	public String userinfo() throws Throwable {
		Map<String, String> map = new HashMap<String, String>();
		map.put("openid", "oK6W9wNQ9zyR5uwhLkNQ61i0ak08");
		log.info("postArg:" + map);
		return httpGet(USERINFO_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), SignUtils.createLinkString(map), d_timeout);
	}
	
	/**
	 * 批量获取用户基本信息
	 * 
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/userinfos.do")
	public String userinfos() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> subMap = new HashMap<String, String>();
		subMap.put("openid", "oK6W9wNQ9zyR5uwhLkNQ61i0ak08");
		List<Object> list=new ArrayList<Object>();
		list.add(subMap);
		map.put("user_list", list);
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(USERINFOS_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	
	
	/**
	 * 创建分组
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/createGroup.do")
	public String createGroup() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> subMap = new HashMap<String, String>();
		subMap.put("name", "test");
		map.put("group", subMap);
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(CREATEGROUP_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	/**
	 * 查询所有分组
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/groups.do")
	public String groups() throws Throwable {
		return httpPost(GROUPS_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), "", d_timeout);
	}
	/**
	 * 查询用户所在分组
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/groupsId.do")
	public String groupsId() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", "oK6W9wNQ9zyR5uwhLkNQ61i0ak08");
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(GROUPS_ID_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	/**
	 * 修改分组名
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/groupUpdate.do")
	public String groupUpdate() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> subMap = new HashMap<String, String>();
		subMap.put("id", "101");
		subMap.put("name", "爱好");
		map.put("group", subMap);
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(GROUPS_UPDATE_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	
	/**
	 * 移动用户分组
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/membersUpdate.do")
	public String membersUpdate() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", "oK6W9wNQ9zyR5uwhLkNQ61i0ak08");
		map.put("to_groupid", "101");
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(MEMBERS_UPDATE_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	/**
	 * 批量移动用户分组
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/groupUpdateBatch.do")
	public String groupUpdateBatch() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> openids=new ArrayList<String>();
		openids.add("oK6W9wNQ9zyR5uwhLkNQ61i0ak08");
		map.put("openid_list", openids);
		map.put("to_groupid", "102");
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(MEMBERS_UPDATE_batch_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}
	/**
	 * 删除分组
	 * @return
	 * @throws Throwable
	 */
	@ResponseBody
	@RequestMapping("/groupDelete.do")
	public String groupDelete() throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> subMap = new HashMap<String, String>();
		subMap.put("id", "103");
		map.put("group", subMap);
		String postArg = JSON.toJSONString(map);
		log.info("postArg:" + postArg);
		return httpPost(DELETE_GROUP_URL.replace("ACCESS_TOKEN", MchInfo.getAccessToken()), postArg, d_timeout);
	}

	public static void main(String[] args) throws Throwable {
		UserController uc = new UserController();
//		uc.userList();MEMBERS_UPDATE_URL
//		uc.createGroup();
//		uc.updateremark();
//		uc.userinfo();
//		uc.userinfos();
//		uc.groups();
//		uc.groupsId();
//		uc.groupUpdate();
//		uc.membersUpdate();
//		uc.groupUpdateBatch();
//		uc.groupDelete();
		uc.groups();
	}
}
