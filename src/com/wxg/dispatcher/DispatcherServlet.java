package com.wxg.dispatcher;

public class DispatcherServlet extends FrameworkServlet{
	@Override
	public void onRefresh(){
		System.out.println("onRefresh()--in--DispatcherServlet");
	}
	public static void main(String[] args) {
		HttpServlet servlet = new DispatcherServlet();
		servlet.init();
	}
}
