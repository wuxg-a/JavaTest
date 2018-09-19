package com.wxg.designpattern.build;

/**
 * Created by wuxg-a on 2018/9/19.
 */
public class BuildTest {

    public static void main(String[] args) {
        BuilderStudent student =  new BuilderStudent.Builder().age(100).num(1000).build();
        System.out.println(student);
    }


}
