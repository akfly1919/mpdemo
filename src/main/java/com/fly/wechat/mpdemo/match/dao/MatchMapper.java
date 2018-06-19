package com.fly.wechat.mpdemo.match.dao;

import com.fly.wechat.mpdemo.match.model.Match;
import com.fly.wechat.mpdemo.match.model.MatchExample;
import java.util.List;

public interface MatchMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Match record);

    int insertSelective(Match record);

    List<Match> selectByExample(MatchExample example);

    Match selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Match record);

    int updateByPrimaryKey(Match record);
}