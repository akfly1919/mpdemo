package com.fly.wechat.mpdemo.match.dao;

import java.util.List;

import com.fly.wechat.mpdemo.match.model.Game;
import com.fly.wechat.mpdemo.match.model.GameExample;

public interface GameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Game record);

    int insertSelective(Game record);

    List<Game> selectByExample(GameExample example);
    
    List<Game> selectByGame(Game example);

    Game selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Game record);
    
    int updateByGameIdSelective(Game record);

    int updateByPrimaryKey(Game record);
}