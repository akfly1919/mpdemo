package com.fly.wechat.mpdemo.match.dao;

import com.fly.wechat.mpdemo.match.model.Team;
import com.fly.wechat.mpdemo.match.model.TeamExample;
import java.util.List;

public interface TeamMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Team record);

	int insertSelective(Team record);

	List<Team> selectByExample(TeamExample example);

	Team selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Team record);

	int updateByTeamIdSelective(Team record);

	int updateByPrimaryKey(Team record);
}