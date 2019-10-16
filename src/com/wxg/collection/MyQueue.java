package com.wxg.collection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wuxg-a on 2018/10/12.
 */
public class MyQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedBlockingDeque<>();
        queue.add("value1");
        queue.add("value2");
        queue.add("value3");
        queue.add("value4");
        queue.add("value5");

        String peekStr = queue.poll();
        peekStr = queue.peek();
        System.out.println();
    }
}
