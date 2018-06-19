package com.fly.wechat.mpdemo.match.dao;

import com.fly.wechat.mpdemo.match.model.TeamPlayer;
import com.fly.wechat.mpdemo.match.model.TeamPlayerExample;
import java.util.List;

public interface TeamPlayerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeamPlayer record);

    int insertSelective(TeamPlayer record);

    List<TeamPlayer> selectByExample(TeamPlayerExample example);

    TeamPlayer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeamPlayer record);

    int updateByPrimaryKey(TeamPlayer record);
}