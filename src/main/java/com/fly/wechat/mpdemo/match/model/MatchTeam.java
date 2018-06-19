package com.fly.wechat.mpdemo.match.model;

public class MatchTeam {
    private Long id;

    private String matchId;

    private String teamId;

    private String teamWName;

    private String groupName;

    private Byte vCount;

    private Byte fCount;

    private Byte qCount;

    private String point;

    private Byte status;

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

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamWName() {
        return teamWName;
    }

    public void setTeamWName(String teamWName) {
        this.teamWName = teamWName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Byte getvCount() {
        return vCount;
    }

    public void setvCount(Byte vCount) {
        this.vCount = vCount;
    }

    public Byte getfCount() {
        return fCount;
    }

    public void setfCount(Byte fCount) {
        this.fCount = fCount;
    }

    public Byte getqCount() {
        return qCount;
    }

    public void setqCount(Byte qCount) {
        this.qCount = qCount;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}