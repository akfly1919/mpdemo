package com.fly.wechat.mpdemo.match.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fly.wechat.mpdemo.match.dao.BaseMapper;
import com.fly.wechat.mpdemo.match.dao.GameMapper;
import com.fly.wechat.mpdemo.match.model.Game;
import com.fly.wechat.mpdemo.match.model.GameExample;
@Repository
public class GameMapperImpl extends BaseMapper  implements GameMapper{
	public String name="com.fly.wechat.mpdemo.match.dao.GameMapper.";

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Game record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Game record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"insertSelective", record);
	}

	@Override
	public List<Game> selectByExample(GameExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Game record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Game record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByGameIdSelective(Game record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(name+"updateByGameIdSelective", record);
	}

	@Override
	public List<Game> selectByGame(Game example) {
		// TODO Auto-generated method stub
		return (List<Game>) sqlSessionTemplate.selectList(name+"selectByGame",example);
	}


}
