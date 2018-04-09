package com.fly.wechat.mpdemo.api;

public class StringRever {
	
	public static String rever(String s){
		if(s.length()==0){
			return "";
		}
		return rever(s.substring(1))+s.charAt(0);
	}

	public static void main(String[] args){
		System.out.println(rever("wangfei"));
	}
}
