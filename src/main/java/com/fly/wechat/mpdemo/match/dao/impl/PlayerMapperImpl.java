package com.fly.wechat.mpdemo.match.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fly.wechat.mpdemo.match.dao.BaseMapper;
import com.fly.wechat.mpdemo.match.dao.PlayerMapper;
import com.fly.wechat.mpdemo.match.model.Player;
@Repository
public class PlayerMapperImpl extends BaseMapper  implements PlayerMapper{
	public String name="com.fly.wechat.mpdemo.match.dao.PlayerMapper.";

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Player record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Player record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"insertSelective",record);
	}

	@Override
	public Player selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Player record) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(name+"updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(Player record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Player> selectByPlayer(Player record) {
		// TODO Auto-generated method stub
		return (List<Player>) sqlSessionTemplate.selectList(name+"selectByPlayer",record);
	}


}
