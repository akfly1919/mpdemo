package com.fly.wechat.mpdemo.match.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fly.wechat.mpdemo.match.dao.BaseMapper;
import com.fly.wechat.mpdemo.match.dao.TeamPlayerMapper;
import com.fly.wechat.mpdemo.match.model.TeamPlayer;
import com.fly.wechat.mpdemo.match.model.TeamPlayerExample;
@Repository
public class TeamPlayerMapperImpl extends BaseMapper  implements TeamPlayerMapper{
	public String name="com.fly.wechat.mpdemo.match.dao.TeamPlayerMapper.";

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TeamPlayer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(TeamPlayer record) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.insert(name+"insertSelective",record);
	}

	@Override
	public List<TeamPlayer> selectByExample(TeamPlayerExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamPlayer selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TeamPlayer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TeamPlayer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TeamPlayer> selectByTeamPlayer(TeamPlayer record) {
		// TODO Auto-generated method stub
		return (List<TeamPlayer>) sqlSessionTemplate.selectList(name+"selectByTeamPlayer",record);
	}

	

}
