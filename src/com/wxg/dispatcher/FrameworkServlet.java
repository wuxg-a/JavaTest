package com.wxg.dispatcher;

public class FrameworkServlet extends HttpServletBean{
	
	@Override
	protected void initServletBean(){
		System.out.println("initServletBean()--in--FrameworkServlet");
		onRefresh();
	}
	public void onRefresh(){
		
	}
}
