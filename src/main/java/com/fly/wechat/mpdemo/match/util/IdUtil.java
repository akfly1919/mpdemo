package com.fly.wechat.mpdemo.match.util;

public class IdUtil {
	
	public static String genId(String post){
		return System.currentTimeMillis()+post;
	}
	public static void main(String[] args){
		int groupNum=2;
		int num=9;
		int count=num/groupNum;
		for(int i=1;i<=groupNum;i++){
			for(int j=1;j<=count&&j<=(num-count*(i-1));j++){
				System.out.println(i+"组"+":"+j);
			}
		}
	}
}
