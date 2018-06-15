package com.fly.wechat.mpdemo.match.dao.impl;

import org.springframework.stereotype.Repository;

import com.fly.wechat.mpdemo.match.dao.BaseMapper;
import com.fly.wechat.mpdemo.match.dao.MatchMapper;
import com.fly.wechat.mpdemo.match.model.Game;
import com.fly.wechat.mpdemo.match.model.Match;
@Repository
public class MatchMapperImpl extends BaseMapper  implements MatchMapper{
	public String name="com.fly.wechat.mpdemo.match.dao.MatchMapper.";

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Match record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"insert",record);
	}

	@Override
	public int insertSelective(Match record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"insertSelective",record);
	}

	@Override
	public Match selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Match record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Match record) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
