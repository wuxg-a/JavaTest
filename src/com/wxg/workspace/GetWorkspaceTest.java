package com.wxg.workspace;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by wuxg-a on 2017/3/24.
 */
public class GetWorkspaceTest {

    final static private String URL = "https://api.glodon.com/workspace/";
    private static String token = "";

    public static void main(String[] args) throws IOException {
        token = OkHttpClientUtil._getToken();
        //OkHttpClientUtil.sendRequest(URL, TOKEN);
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000, 300*1000);

        while(true){//这个是用来停止此任务的,否则就一直循环执行此任务
            try{
                int in = System.in.read();
                if(in == 's'){
                    timer.cancel();//使用这个方法退出任务
                    break;
                }
            } catch (Exception e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    static class MyTask extends TimerTask{
        public void run(){
            OkHttpClientUtil.sendRequest(URL, token);
        }
    }

}

