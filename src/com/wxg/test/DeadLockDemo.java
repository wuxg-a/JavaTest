package com.wxg.test;

public class DeadLockDemo {  
    private static String A="A";  
    private static String B="B";  
    public static void main(String[] args){  
    	String str="5678llXYZ";  
    	String[] b = str.split("l", 2);
    	System.out.println(b.length);
        //new DeadLockDemo().deadLock();  
    }   
    private void deadLock(){  
        Thread threadA=new Thread(new Runnable(){  
            @Override  
            public void run(){  
                synchronized(A){  
                    try {  
                        Thread.currentThread().sleep(2000);  
                    } catch (InterruptedException e) {   
                        e.printStackTrace();  
                    }  
                    synchronized(B){  
                        System.out.println("AB");  
                    }  
                }  
            }  
        });  
        Thread threadB=new Thread(new Runnable(){  
            @Override  
            public void run(){  
                synchronized(B){  
                    try {  
                        Thread.currentThread().sleep(2000);  
                    } catch (InterruptedException e) {   
                        e.printStackTrace();  
                    }  
                    synchronized(A){
                        System.out.println("BA");  
                    }  
                }  
            }  
        });  
        threadA.start();  
        threadB.start();  
    }  
}  
