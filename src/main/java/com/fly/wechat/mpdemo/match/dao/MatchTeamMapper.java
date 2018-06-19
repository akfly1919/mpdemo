package com.fly.wechat.mpdemo.match.dao;

import com.fly.wechat.mpdemo.match.model.MatchTeam;
import com.fly.wechat.mpdemo.match.model.MatchTeamExample;
import java.util.List;

public interface MatchTeamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MatchTeam record);

    int insertSelective(MatchTeam record);

    List<MatchTeam> selectByExample(MatchTeamExample example);

    MatchTeam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MatchTeam record);

    int updateByPrimaryKey(MatchTeam record);
}