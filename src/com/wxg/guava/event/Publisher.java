package com.wxg.guava.event;

import com.google.common.eventbus.EventBus;

/**
 * Created by wuxg-a on 2017/7/19.
 */
public class Publisher {

    public static void sendMessage(String message){
        EventBusFactory.getEventBus().post(message);
    }
}
