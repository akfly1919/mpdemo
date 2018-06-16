package com.fly.wechat.mpdemo.match.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fly.wechat.mpdemo.match.dao.BaseMapper;
import com.fly.wechat.mpdemo.match.dao.TeamMapper;
import com.fly.wechat.mpdemo.match.model.Game;
import com.fly.wechat.mpdemo.match.model.Team;
@Repository
public class TeamMapperImpl extends BaseMapper  implements TeamMapper{
	public String name="com.fly.wechat.mpdemo.match.dao.TeamMapper.";

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Team record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Team record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"insert",record);
	}

	@Override
	public Team selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Team record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(Team record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Team> selectByTeam(Team record) {
		// TODO Auto-generated method stub
		return null;
	}


}
