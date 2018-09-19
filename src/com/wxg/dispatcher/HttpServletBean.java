package com.wxg.dispatcher;

public class HttpServletBean implements HttpServlet{

	@Override
	public void init() {
		System.out.println("init()--in--HttpServletBean!");
		initServletBean();
	}
	protected void initServletBean(){
		
	}

}
