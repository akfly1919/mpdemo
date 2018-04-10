package com.fly.wechat.mpdemo.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CalmNBA {

	public static void main(String[] args) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("开拓者", 48);
		map.put("爵士", 47);
		map.put("鹈鹕", 47);
		map.put("马刺", 47);
		map.put("雷霆", 47);
		map.put("森林狼", 46);
		map.put("掘金", 46);
		Set<String> set=new TreeSet<String>();
		zuhe(set);
		for(String s:set){
			Map<String, Integer> map1 = new TreeMap<String, Integer>(map);
			calm(s, map1);
			printMap(map1);
			System.out.println("");
		}

	}
	
	public static Set<String> zuhe(Set<String> set){
		Random r=new Random();
		String s="";
		s=s+(r.nextInt(10)>5?"a":"A");
		s=s+(r.nextInt(10)>5?"b":"B");
		s=s+(r.nextInt(10)>5?"c":"C");
		s=s+(r.nextInt(10)>5?"d":"D");
		s=s+(r.nextInt(10)>5?"e":"E");
		set.add(s);
		return set.size()==32?set:zuhe(set);
	}

	public static void printMap(Map<String, Integer> map) {
		Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue() - o1.getValue();
			}
		};
		// map转换成list进行排序
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		// 排序
		Collections.sort(list, valueComparator);
		for (Map.Entry<String, Integer> entry : list) {
			System.out.print(entry.getKey() + ":" + entry.getValue());
		}

	}

	public static void calm(String s, Map<String, Integer> map) {
		System.out.print(s);
		if (s.indexOf("a") != -1) {
			map.put("爵士", map.get("爵士") + 1);
		}
		if (s.indexOf("b") != -1) {
			map.put("爵士", map.get("爵士") + 1);
		}
		if (s.indexOf("B") != -1) {
			map.put("开拓者", map.get("开拓者") + 1);
		}
		if (s.indexOf("c") != -1) {
			map.put("马刺", map.get("马刺") + 1);
		}
		if (s.indexOf("C") != -1) {
			map.put("鹈鹕", map.get("鹈鹕") + 1);
		}
		if (s.indexOf("D") != -1) {
			map.put("雷霆", map.get("雷霆") + 1);
		}
		if (s.indexOf("e") != -1) {
			map.put("森林狼", map.get("森林狼") + 1);
		}
		if (s.indexOf("E") != -1) {
			map.put("掘金", map.get("掘金") + 1);
		}
	}
}
