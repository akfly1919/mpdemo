package com.fly.wechat.mpdemo.match.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	public static void shuffle(String group, int num, int count) {
		List<String> games = new ArrayList<String>();
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
		}
		for (int i = 1; i <= num - 1; i++) {
			System.out.println("第" + i + "轮比赛:");
			for (int j = 0; j < list.size() / 2; j++) {
				String a = group + list.get(j);
				String b = group + list.get(list.size() - 1 - j);
				System.out.println(a + "Vs" + b);
				System.out.println(j + "Vs" + (list.size() - 1 - j));
				games.add(a + "Vs" + b);
			}
			int temp = list.pollLast(); // 获取最后一个元素
			list.add(1, temp);// 将最后一个元素放在List的第二个位置
		}
	}

	public static void main(String[] args) {
		shuffle("A", 5, 1);
	}

}
