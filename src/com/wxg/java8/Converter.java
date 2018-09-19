package com.wxg.java8;

/**
 * Created by wuxg-a on 2017/9/15.
 */
@FunctionalInterface
interface Converter<F, T> {
    //必须仅包含一个抽象方法，用于lambda表达式给出具体实现。这里可以包含扩展方法
    T convert(F from);
}
