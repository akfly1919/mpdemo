package com.fly.wechat.mpdemo.api.lqtime;

import java.util.List;

public class FeedModel {

	String year;
	String day;
	String time;
	String source;
	String context;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<String> getNewsTags() {
		return newsTags;
	}
	public void setNewsTags(List<String> newsTags) {
		this.newsTags = newsTags;
	}
	List<String> images;
	List<String> newsTags;
	@Override
	public String toString() {
		return "FeedModel [year=" + year + ", day=" + day + ", time=" + time + ", source=" + source + ", context="
				+ context + ", images=" + images + ", newsTags=" + newsTags + "]";
	}

}
