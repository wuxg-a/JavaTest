package com.wxg.test.fastjson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.alibaba.fastjson.JSON;

public class MainTest {

	public static void main(String[] args) {

		StringBuffer sb = readJsonStringFromFile("F:/fastJson.txt");
		System.out.println(sb.toString());
		Country c = JSON.parseObject(sb.toString(), Country.class);
		System.out.println(c.getName());
		System.out.println(c.getProvince());
	}

	private static StringBuffer readJsonStringFromFile(String path){
		Reader reader = null;
		BufferedReader br = null;
			
		try {
			reader = new FileReader(path);
			br = new BufferedReader(reader);
			StringBuffer sb = new StringBuffer();
			String data = "";
			while((data = br.readLine()) != null){
				sb.append(data);
			}
			return sb;
		} catch (IOException e) {
			e.printStackTrace();
		} finally{	
			try {
				reader.close();
				//br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
