package com.wxg.guava.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by wuxg-a on 2017/7/19.
 */
public class EventBusFactory {

    private static EventBus eventBus = null;

    public static EventBus getEventBus(){
        if(eventBus == null){
            synchronized (EventBusFactory.class){
                if(eventBus == null){
                    eventBus = new EventBus();
                }
            }
        }

        eventBus.register(new Object(){
            @Subscribe
            public void handleUserInfoChangeEvent(String message){
                System.out.println("处理用户信息变化事件：" + message);
            }
            });
        return eventBus;
    }
}
