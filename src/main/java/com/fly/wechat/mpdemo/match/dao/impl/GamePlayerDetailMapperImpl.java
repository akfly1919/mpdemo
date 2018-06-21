package com.fly.wechat.mpdemo.match.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fly.wechat.mpdemo.match.dao.BaseMapper;
import com.fly.wechat.mpdemo.match.dao.GamePlayerDetailMapper;
import com.fly.wechat.mpdemo.match.model.Game;
import com.fly.wechat.mpdemo.match.model.GameExample;
import com.fly.wechat.mpdemo.match.model.GamePlayerDetail;
import com.fly.wechat.mpdemo.match.model.GamePlayerDetailExample;
@Repository
public class GamePlayerDetailMapperImpl extends BaseMapper  implements GamePlayerDetailMapper{
	public String name="com.fly.wechat.mpdemo.match.dao.GamePlayerDetailMapper.";

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(GamePlayerDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(GamePlayerDetail record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"insertSelective", record);
	}

	@Override
	public List<GamePlayerDetail> selectByExample(GamePlayerDetailExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GamePlayerDetail selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(GamePlayerDetail record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(name+"updateByPrimaryKeySelective", record);
	}

	@Override
	public int updateByPrimaryKey(GamePlayerDetail record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByGamePlayerDetail(GamePlayerDetail record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(name+"updateByGamePlayerDetail", record);
	}

	

}
