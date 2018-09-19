package com.wxg.designpattern.build;

/**
 * Created by wuxg-a on 2018/9/19.
 */
public class BuilderStudent {
    private int age ;
    private int num;


    public static class Builder{
        private  int age;
        private  int num;

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder num(int num){
            this.num = num;
            return this;
        }

        public BuilderStudent build(){
            return new BuilderStudent(this);
        }
    }

    public BuilderStudent(Builder builder){
        this.age = builder.age;
        this.num = builder.num;
    }
}
