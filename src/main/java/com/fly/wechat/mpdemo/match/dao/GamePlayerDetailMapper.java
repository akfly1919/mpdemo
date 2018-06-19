package com.fly.wechat.mpdemo.match.dao;

import com.fly.wechat.mpdemo.match.model.GamePlayerDetail;
import com.fly.wechat.mpdemo.match.model.GamePlayerDetailExample;
import java.util.List;

public interface GamePlayerDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GamePlayerDetail record);

    int insertSelective(GamePlayerDetail record);

    List<GamePlayerDetail> selectByExample(GamePlayerDetailExample example);

    GamePlayerDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GamePlayerDetail record);

    int updateByPrimaryKey(GamePlayerDetail record);
}