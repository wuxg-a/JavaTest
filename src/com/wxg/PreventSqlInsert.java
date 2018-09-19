package com.wxg;

public class PreventSqlInsert {

	private static final String INJ_STR = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
	
	public static void main(String[] args) {
		
//		boolean ifSqlInj = ifSqlInj("wuand*");
//		if(ifSqlInj){
//			System.out.println("存在sql注入危险！");
//		}
		String afterHandleSqlString = handleInjectesSql("wuand*");
		System.out.println(afterHandleSqlString);
	}
	
	private static boolean ifSqlInj(String inputSql){
		String[] injArray = INJ_STR.split("\\|");
		for(int i=0; i<injArray.length; i++){
			if(inputSql.indexOf(injArray[i]) > 0){
				return true;
			}
		}
		return false;
	}
	
	private static String handleInjectesSql(String inputSql){
		String[] injArray = INJ_STR.split("\\|");
		for(int i=0; i<injArray.length; i++){
			if(inputSql.indexOf(injArray[i]) > 0){
				inputSql = inputSql.replace(injArray[i], "");
			}
		}
		return inputSql;
	}
}
