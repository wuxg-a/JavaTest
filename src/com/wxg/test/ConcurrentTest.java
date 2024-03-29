package com.wxg.test;

public class ConcurrentTest {  
    private static final long count=100001;  
    public static void main(String[] args) throws InterruptedException{  
        concurrency();  
        serial();  
    }  
    private static void concurrency() throws InterruptedException{  
        long start=System.currentTimeMillis();  
        Thread thread=new Thread(new Runnable(){  
            @Override  
            public void run(){  
                int a=0;  
                for(long i=0;i<count;i++){  
                    a++;  
                }  
            }  
        });  
        thread.start();  
        int b=0;  
        for(long i=0;i<count;i++){  
            b--;  
        }  
        thread.join();  
        long time=System.currentTimeMillis()-start;  
        System.out.println("concurrency:"+time);   
    }  
  
    private static void serial(){  
        long start=System.currentTimeMillis();  
        int a=0;  
        for(long i=0;i<count;i++){  
            a++;  
        }  
        int b=0;  
        for(long i=0;i<count;i++){  
            b--;;  
        }  
        long time=System.currentTimeMillis()-start;  
        System.out.println("serial:"+time);   
    }  
}  
