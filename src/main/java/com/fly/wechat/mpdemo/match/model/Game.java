package com.fly.wechat.mpdemo.match.model;

import java.util.Date;

public class Game {
    private Long id;

    private String matchId;

    private String gameId;

    private String name;

    private String aid;

    private String bid;

    private Integer ascore;

    private Integer bscore;

    private String ascoreDetail;

    private String bscoreDetail;

    private String gameDidian;

    private String address;

    private String latitude;

    private String longitude;

    private Date gameTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Integer getAscore() {
        return ascore;
    }

    public void setAscore(Integer ascore) {
        this.ascore = ascore;
    }

    public Integer getBscore() {
        return bscore;
    }

    public void setBscore(Integer bscore) {
        this.bscore = bscore;
    }

    public String getAscoreDetail() {
        return ascoreDetail;
    }

    public void setAscoreDetail(String ascoreDetail) {
        this.ascoreDetail = ascoreDetail;
    }

    public String getBscoreDetail() {
        return bscoreDetail;
    }

    public void setBscoreDetail(String bscoreDetail) {
        this.bscoreDetail = bscoreDetail;
    }

    public String getGameDidian() {
        return gameDidian;
    }

    public void setGameDidian(String gameDidian) {
        this.gameDidian = gameDidian;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getGameTime() {
        return gameTime;
    }

    public void setGameTime(Date gameTime) {
        this.gameTime = gameTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}