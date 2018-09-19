package com.wxg;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;

public class Token {

	public static void main(String[] args) {
		//System.out.println(generateBase64());
		System.out.println(toJson());
		

	}
	private static String generateBase64() {
        StringBuilder stringBuilder = new StringBuilder("u4RzLv2rRtnOHVFaAPOwhBVsYZpif8tv")
                .append(":")
                .append("KklR9GzQHJ4TS3b7X7I6ywXdVAVQNyo5");
        return Base64.encodeBase64String(stringBuilder.toString().getBytes());
    }
	
	
	private static String toJson( ){
		Map<Object,Object> jsonMap = new HashMap<>();
		jsonMap.clear();
		List<Object> list = new ArrayList<>();
		list.add("12");
		list.add("16");
		jsonMap.put("ids", list);
		jsonMap.put("name", "123456789");
		jsonMap.put("parentId", "parentId");
		jsonMap.put("position", 100);
		jsonMap.put("creator", (byte)2);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		
		return jsonString;
	}
	
	@SuppressWarnings("deprecation")
	private static String urlEncode(String originalUrl) throws UnsupportedEncodingException{
		return URLEncoder.encode(originalUrl, "UTF-8");
	}
}
