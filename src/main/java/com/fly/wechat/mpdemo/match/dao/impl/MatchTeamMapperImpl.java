package com.fly.wechat.mpdemo.match.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fly.wechat.mpdemo.match.dao.BaseMapper;
import com.fly.wechat.mpdemo.match.dao.MatchTeamMapper;
import com.fly.wechat.mpdemo.match.model.MatchTeam;
import com.fly.wechat.mpdemo.match.model.MatchTeamExample;
@Repository
public class MatchTeamMapperImpl extends BaseMapper  implements MatchTeamMapper{
	public String name="com.fly.wechat.mpdemo.match.dao.MatchTeamMapper.";

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(MatchTeam record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(MatchTeam record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"insertSelective", record);
	}

	@Override
	public List<MatchTeam> selectByExample(MatchTeamExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchTeam selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(MatchTeam record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(MatchTeam record) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
