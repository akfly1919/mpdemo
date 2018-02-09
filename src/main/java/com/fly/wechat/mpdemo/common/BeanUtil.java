package com.fly.wechat.mpdemo.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class BeanUtil {
	public static String map2xml(Map<String, String> dataMap) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("<xml>");
		Set<String> objSet = dataMap.keySet();
		for (String key : objSet) {
			if (key == null) {
				continue;
			}
			strBuilder.append("\n");
			strBuilder.append("<").append(key.toString()).append("><![CDATA[");
			String value = dataMap.get(key);
			strBuilder.append(value);
			strBuilder.append("]]></").append(key.toString()).append(">\n");
		}
		strBuilder.append("</xml>");
		return strBuilder.toString();
	}
	public static String list2xml(List<Map<String, String>> list) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("");
		for (Map<String, String> map : list) {
			strBuilder.append("<item>");
			for (String key : map.keySet()) {
				strBuilder.append("\n");
				strBuilder.append("<").append(key.toString()).append("><![CDATA[");
				String value = map.get(key);
				strBuilder.append(value);
				strBuilder.append("]]></").append(key.toString()).append(">\n");
			}
			strBuilder.append("</item>");
		}
		strBuilder.append("");
		return strBuilder.toString();
	}

	public static String map2uri(Map<String, String> dataMap) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("");
		Set<String> objSet = dataMap.keySet();
		for (String key : objSet) {
			if (key == null) {
				continue;
			}
			strBuilder.append(key.toString()).append("=");
			String value = dataMap.get(key);
			strBuilder.append(value).append("&");
		}
		String uri = strBuilder.toString();
		if (uri.length() == 0) {
			return uri;
		}
		return uri.substring(0, uri.length() - 1);
	}

	public static Map<String, String> xml2Map(String xml) {
		try {
			Map<String, String> map = new HashMap<String, String>();
			Document document = DocumentHelper.parseText(xml);
			Element nodeElement = document.getRootElement();
			List node = nodeElement.elements();
			for (Iterator it = node.iterator(); it.hasNext();) {
				Element elm = (Element) it.next();
				map.put(elm.getName(), elm.getText());
				elm = null;
			}
			node = null;
			nodeElement = null;
			document = null;
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, String> json2Map(String json) {
		try {
			Map<String, String> map = new HashMap<String, String>();
			Map<String, Object> objMap = JSON.parseObject(json);
			for (String key : objMap.keySet()) {
				map.put(key, objMap.get(key) + "");
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String formatJson(String jsonStr) {
		if (null == jsonStr || "".equals(jsonStr))
			return "";
		StringBuilder sb = new StringBuilder();
		char last = '\0';
		char current = '\0';
		int indent = 0;
		for (int i = 0; i < jsonStr.length(); i++) {
			last = current;
			current = jsonStr.charAt(i);
			switch (current) {
			case '{':
			case '[':
				sb.append(current);
				sb.append('\n');
				indent++;
				addIndentBlank(sb, indent);
				break;
			case '}':
			case ']':
				sb.append('\n');
				indent--;
				addIndentBlank(sb, indent);
				sb.append(current);
				break;
			case ',':
				sb.append(current);
				if (last != '\\') {
					sb.append('\n');
					addIndentBlank(sb, indent);
				}
				break;
			default:
				sb.append(current);
			}
		}

		return sb.toString();
	}
	
	private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }

}
