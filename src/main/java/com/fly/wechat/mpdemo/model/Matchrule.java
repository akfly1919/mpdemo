package com.fly.wechat.mpdemo.model;

public class Matchrule {
	public String group_id; 
	public String sex;
	public String client_platform_type;
	public String country;
	public String province;
	public String city;
	public String language;
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClient_platform_type() {
		return client_platform_type;
	}
	public void setClient_platform_type(String client_platform_type) {
		this.client_platform_type = client_platform_type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Matchrule(String group_id, String sex, String client_platform_type, String country, String province,
			String city, String language) {
		super();
		this.group_id = group_id;
		this.sex = sex;
		this.client_platform_type = client_platform_type;
		this.country = country;
		this.province = province;
		this.city = city;
		this.language = language;
	}
	public Matchrule(){
		
	}
	
}
