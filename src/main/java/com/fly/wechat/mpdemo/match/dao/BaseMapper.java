package com.fly.wechat.mpdemo.match.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

public class BaseMapper {
	protected SqlSessionTemplate sqlSessionTemplate;
	@Resource
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
		this.sqlSessionTemplate = sqlSessionTemplate;
		this.sqlSessionTemplate.getConfiguration().buildAllStatements();
	}
}
