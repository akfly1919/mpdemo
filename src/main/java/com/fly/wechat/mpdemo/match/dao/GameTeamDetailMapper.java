package com.fly.wechat.mpdemo.match.dao;

import com.fly.wechat.mpdemo.match.model.GameTeamDetail;
import com.fly.wechat.mpdemo.match.model.GameTeamDetailExample;
import java.util.List;

public interface GameTeamDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GameTeamDetail record);

    int insertSelective(GameTeamDetail record);

    List<GameTeamDetail> selectByExample(GameTeamDetailExample example);

    GameTeamDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GameTeamDetail record);

    int updateByPrimaryKey(GameTeamDetail record);
}