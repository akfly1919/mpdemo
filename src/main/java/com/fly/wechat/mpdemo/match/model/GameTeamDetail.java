package com.fly.wechat.mpdemo.match.model;

public class GameTeamDetail {
    private Long id;

    private String gameId;

    private String teamId;

    private Byte jieci;

    private Byte pts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Byte getJieci() {
        return jieci;
    }

    public void setJieci(Byte jieci) {
        this.jieci = jieci;
    }

    public Byte getPts() {
        return pts;
    }

    public void setPts(Byte pts) {
        this.pts = pts;
    }
}