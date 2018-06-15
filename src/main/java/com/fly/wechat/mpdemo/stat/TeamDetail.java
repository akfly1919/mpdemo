package com.fly.wechat.mpdemo.stat;

import java.util.Date;

public class TeamDetail {
	private long id;
	private long teamId;
	private long gameId;
	private long matchId;
	private int score;
	private int result;//0 弃权 1失败 2成功
	private Date createTime;
}
