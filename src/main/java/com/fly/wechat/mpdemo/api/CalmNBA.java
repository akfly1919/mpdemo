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
	
	public static Map<String, Integer> l1Map = new TreeMap<String, Integer>();
	public static Map<String, Integer> l2Map = new TreeMap<String, Integer>();
	public static Map<String, Integer> l3Map = new TreeMap<String, Integer>();
	public static Map<String, Integer> l4Map = new TreeMap<String, Integer>();
	public static Map<String, Integer> l5Map = new TreeMap<String, Integer>();
	public static Map<String, Integer> l6Map = new TreeMap<String, Integer>();
	public static Map<String, Integer> l7Map = new TreeMap<String, Integer>();
	public static Map<String, Integer> l8Map = new TreeMap<String, Integer>();
	static {
		l1Map.put("掘金", 1);
		l1Map.put("鹈鹕", 0);
		
		l2Map.put("森林狼", 1);
		l2Map.put("鹈鹕", 0);
		
		l3Map.put("森林狼", 0);
		l3Map.put("马刺", 1);
		
		l4Map.put("掘金", 1);
		l4Map.put("马刺", 0);
		
		l5Map.put("爵士", 1);
		l5Map.put("雷霆", 2);
		l5Map.put("鹈鹕", 0);
		
		l6Map.put("爵士", 1);
		l6Map.put("雷霆", 2);
		l6Map.put("马刺", 0);
		
		l7Map.put("开拓者", 2);
		l7Map.put("雷霆", 0);
		l7Map.put("鹈鹕", 1);
		
		l8Map.put("开拓者", 2);
		l8Map.put("雷霆", 0);
		l8Map.put("马刺", 1);
		
	}

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
	
	public static Map<String, Integer> cp(Entry<String, Integer> o1, Entry<String, Integer> o2){
		if(l1Map.containsKey(o1.getKey())&&l1Map.containsKey(o2.getKey())){
			return l1Map;
		}
		if(l2Map.containsKey(o1.getKey())&&l2Map.containsKey(o2.getKey())){
			return l2Map;
		}
		if(l3Map.containsKey(o1.getKey())&&l3Map.containsKey(o2.getKey())){
			return l3Map;
		}
		if(l4Map.containsKey(o1.getKey())&&l4Map.containsKey(o2.getKey())){
			return l4Map;
		}
		if(l5Map.containsKey(o1.getKey())&&l5Map.containsKey(o2.getKey())){
			return l5Map;
		}
		if(l6Map.containsKey(o1.getKey())&&l6Map.containsKey(o2.getKey())){
			return l6Map;
		}
		if(l7Map.containsKey(o1.getKey())&&l7Map.containsKey(o2.getKey())){
			return l7Map;
		}
		if(l8Map.containsKey(o1.getKey())&&l8Map.containsKey(o2.getKey())){
			return l8Map;
		}
		return null;
	}
	
	public static Set<String> zuhe(Set<String> set){
		Random r=new Random();
		String s="";
		s=s+(r.nextInt(10)>5?"a":"a");
		s=s+(r.nextInt(10)>5?"b":"B");
		s=s+(r.nextInt(10)>5?"c":"C");
		s=s+(r.nextInt(10)>5?"D":"D");
		s=s+(r.nextInt(10)>5?"e":"E");
		set.add(s);
		return set.size()==8?set:zuhe(set);
	}

	public static void printMap(Map<String, Integer> map) {
		
		final Map<Integer,Set<String>> mset=new TreeMap<Integer,Set<String>>();
		Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if((o2.getValue() - o1.getValue())==0){
					if(mset.containsKey(o1.getValue())){
						mset.get(o1.getValue()).add(o2.getKey());
						mset.get(o1.getValue()).add(o1.getKey());
					}else{
						Set<String> set=new TreeSet<String>();
						set.add(o1.getKey());
						set.add(o2.getKey());
						mset.put(o1.getValue(), set);
					}
					Map<String, Integer> cpm=cp(o1, o2);
					return cpm.get(o2.getKey())-cpm.get(o1.getKey());
				}
				return o2.getValue() - o1.getValue();
			}
			
		};
		// map转换成list进行排序
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		// 排序
		Collections.sort(list, valueComparator);
		int i=3;
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println((i++)+entry.getKey() + ":" + entry.getValue()+" ");
		}
//		System.out.println();
//		for (Map.Entry<Integer,Set<String>> entry : mset.entrySet()) {
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}

	}

	public static void calm(String s, Map<String, Integer> map) {
		System.out.println(printZN(s));
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
	public static String printZN(String s){
		String scr="";
//		if (s.indexOf("a") != -1) {
//			scr=scr+"勇士输爵士,";
//		}
//		if (s.indexOf("A") != -1) {
//			scr=scr+"勇士赢爵士,";
//		}
		if (s.indexOf("b") != -1) {
			scr=scr+"开拓者输爵士,";
		}
		if (s.indexOf("B") != -1) {
			scr=scr+"开拓者赢爵士,";
		}
		if (s.indexOf("c") != -1) {
			scr=scr+"鹈鹕输马刺,";
		}
		if (s.indexOf("C") != -1) {
			scr=scr+"鹈鹕赢马刺,";
		}
//		if (s.indexOf("d") != -1) {
//			scr=scr+"雷霆输灰熊,";
//		}
//		if (s.indexOf("D") != -1) {
//			scr=scr+"雷霆赢灰熊,";
//		}
		if (s.indexOf("e") != -1) {
			scr=scr+"森林狼赢掘金";
		}
		if (s.indexOf("E") != -1) {
			scr=scr+"森林狼输掘金";
		}
		
		return scr;
	}
}
