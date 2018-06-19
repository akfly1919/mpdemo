package com.fly.wechat.mpdemo.match.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fly.wechat.mpdemo.match.dao.BaseMapper;
import com.fly.wechat.mpdemo.match.dao.TeamMapper;
import com.fly.wechat.mpdemo.match.model.Game;
import com.fly.wechat.mpdemo.match.model.Team;
import com.fly.wechat.mpdemo.match.model.TeamExample;
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
		return sqlSessionTemplate.insert(name+"insertSelective", record);
	}

	@Override
	public List<Team> selectByExample(TeamExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Team record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(name+"updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(Team record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByTeamIdSelective(Team record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(name+"updateByTeamIdSelective", record);
	}

	@Override
	public List<Team> selectByTeam(Team example) {
		// TODO Auto-generated method stub
		return (List<Team>) sqlSessionTemplate.selectList(name+"selectByTeam",example);
	}

	@Override
	public List<Team> selectByMatchId(String matchId) {
		// TODO Auto-generated method stub
		return (List<Team>) sqlSessionTemplate.selectList(name+"selectByMatchId",matchId);
	}

}
