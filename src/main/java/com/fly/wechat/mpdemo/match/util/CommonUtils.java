package com.fly.wechat.mpdemo.match.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fly.wechat.mpdemo.match.dao.GameMapper;
import com.fly.wechat.mpdemo.match.model.Game;

public class CommonUtils {
	/**
	 * 
	 * @param group
	 *            分组
	 * @param num
	 *            球队数
	 * @param count
	 *            一天几赛
	 */
	public static List<Game> shuffle(String group, int num, int total) {
		List<Game> games = new ArrayList<Game>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (num % 2 == 0) {
			for (int i = 0; i < num; i++) {
				list.add(i + 1);
			}
		} else {
			for (int i = 0; i < num; i++) {
				list.add(i + 1);
			}
			list.add(0);
			num=num+1;
		}
		for (int i = 1; i <= num-1; i++) {
			for (int j = 0; j < list.size() / 2; j++) {
				Game g=new Game();
				g.setName("第" + i + "轮比赛  "+group+"组:");
				g.setAid(Long.valueOf(list.get(j)));
				g.setBid(Long.valueOf(list.get(list.size() - 1 - j)));
				games.add(g);
			}
			int temp = list.pollLast(); // 获取最后一个元素
			list.add(1, temp);// 将最后一个元素放在List的第二个位置
		}
		return games;
	}

}
