package com.fly.wechat.mpdemo.match.dao;

import com.fly.wechat.mpdemo.match.model.GamePlayerDetail;

public interface GamePlayerDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_player_detail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_player_detail
     *
     * @mbggenerated
     */
    int insert(GamePlayerDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_player_detail
     *
     * @mbggenerated
     */
    int insertSelective(GamePlayerDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_player_detail
     *
     * @mbggenerated
     */
    GamePlayerDetail selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_player_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GamePlayerDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table game_player_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(GamePlayerDetail record);
}