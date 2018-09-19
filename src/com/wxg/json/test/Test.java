package com.wxg.json.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 * Created by wuxg-a on 2017/7/26.
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        String[] teach = {"1","2"};
        student.setTeachers(teach);
        student.setName("wxg");
        student.setAge("26");

        String str = JSON.toJSONString(student);
        System.out.println(str);
    }
}
