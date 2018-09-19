package com.wxg.proxytest;

public class UserServiceImpl1 implements UserService{

	@Override
	public void save() {
		 System.out.println("保存用户1...");
	}

	@Override
	public void update() {
		System.out.println("修改用户1...");
	}

	@Override
	public void delete() {
		System.out.println("删除用户1...");
	}

	@Override
	public void find() {
		System.out.println("查询用户1...");		
	}
}
