package com.fly.wechat.mpdemo.match.model;

import java.util.Date;

public class Match {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.desc
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.openid
     *
     * @mbggenerated
     */
    private String openid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.unionid
     *
     * @mbggenerated
     */
    private String unionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.token
     *
     * @mbggenerated
     */
    private String token;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.begTime
     *
     * @mbggenerated
     */
    private Date begtime;
    
    private int num;
    private int groupNum;
    
    private String picUrl;

    public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.endTime
     *
     * @mbggenerated
     */
    private Date endtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column match.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.id
     *
     * @return the value of match.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.id
     *
     * @param id the value for match.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.name
     *
     * @return the value of match.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.name
     *
     * @param name the value for match.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.desc
     *
     * @return the value of match.desc
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.desc
     *
     * @param desc the value for match.desc
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.openid
     *
     * @return the value of match.openid
     *
     * @mbggenerated
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.openid
     *
     * @param openid the value for match.openid
     *
     * @mbggenerated
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.unionid
     *
     * @return the value of match.unionid
     *
     * @mbggenerated
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.unionid
     *
     * @param unionid the value for match.unionid
     *
     * @mbggenerated
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.token
     *
     * @return the value of match.token
     *
     * @mbggenerated
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.token
     *
     * @param token the value for match.token
     *
     * @mbggenerated
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.status
     *
     * @return the value of match.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.status
     *
     * @param status the value for match.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.begTime
     *
     * @return the value of match.begTime
     *
     * @mbggenerated
     */
    public Date getBegtime() {
        return begtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.begTime
     *
     * @param begtime the value for match.begTime
     *
     * @mbggenerated
     */
    public void setBegtime(Date begtime) {
        this.begtime = begtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.endTime
     *
     * @return the value of match.endTime
     *
     * @mbggenerated
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.endTime
     *
     * @param endtime the value for match.endTime
     *
     * @mbggenerated
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column match.create_time
     *
     * @return the value of match.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column match.create_time
     *
     * @param createTime the value for match.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", name=" + name + ", desc=" + desc + ", openid=" + openid + ", unionid=" + unionid
				+ ", token=" + token + ", status=" + status + ", begtime=" + begtime + ", num=" + num + ", groupNum="
				+ groupNum + ", picUrl=" + picUrl + ", endtime=" + endtime + ", createTime=" + createTime + "]";
	}

    
}