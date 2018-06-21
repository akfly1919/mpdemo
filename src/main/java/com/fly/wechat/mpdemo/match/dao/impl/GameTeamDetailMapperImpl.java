package com.fly.wechat.mpdemo.match.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fly.wechat.mpdemo.match.dao.BaseMapper;
import com.fly.wechat.mpdemo.match.dao.GameTeamDetailMapper;
import com.fly.wechat.mpdemo.match.model.Game;
import com.fly.wechat.mpdemo.match.model.GameExample;
import com.fly.wechat.mpdemo.match.model.GameTeamDetail;
import com.fly.wechat.mpdemo.match.model.GameTeamDetailExample;
@Repository
public class GameTeamDetailMapperImpl extends BaseMapper  implements GameTeamDetailMapper{
	public String name="com.fly.wechat.mpdemo.match.dao.GameTeamDetailMapper.";

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(GameTeamDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(GameTeamDetail record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"insertSelective",record);
	}

	@Override
	public List<GameTeamDetail> selectByExample(GameTeamDetailExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameTeamDetail selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(GameTeamDetail record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(name+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(GameTeamDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}


}
