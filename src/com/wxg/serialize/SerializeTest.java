package com.wxg.serialize;

import java.io.*;

/**
 * Created by wuxg-a on 2018/10/11.
 */
public class SerializeTest {
    public static void main(String[] args) {
        try {
           File file = new File("D:" + File.separator + "s.txt");
           OutputStream os = new FileOutputStream(file);
           ObjectOutputStream oos = new ObjectOutputStream(os);
           oos.writeObject(new SerializeObject("hello", "world"));

           FileInputStream is = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(is);
           SerializeObject object = (SerializeObject)ois.readObject();
           object.getName();
           object.getAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
