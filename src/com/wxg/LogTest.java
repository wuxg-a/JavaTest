package com.wxg;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class LogTest {
	private static Logger logger = Logger.getLogger(LogTest.class);
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		// 记录debug级别的信息  
//        logger.debug("This is debug message.");  
//        // 记录info级别的信息  
//        logger.info("This is info message.");  
//        // 记录error级别的信息  
//        logger.error("This is error message."); 
//		Class<?> classType=Class.forName("com.wxg.Student");
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		DateTime time = new DateTime(timestamp);
		System.out.println(time);
	}

}
