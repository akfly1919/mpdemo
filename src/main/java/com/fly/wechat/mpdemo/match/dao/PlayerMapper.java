package com.fly.wechat.mpdemo.match.dao;

import com.fly.wechat.mpdemo.match.model.Player;
import com.fly.wechat.mpdemo.match.model.PlayerExample;
import java.util.List;

public interface PlayerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Player record);

    int insertSelective(Player record);

    List<Player> selectByExample(PlayerExample example);

    Player selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);
}