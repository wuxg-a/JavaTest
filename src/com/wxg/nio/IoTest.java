package com.wxg.nio;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by wuxg-a on 2017/5/27.
 */
public class IoTest{

    private static final String baseDir = "D:\\";

    public static void main(String[]args) throws IOException {
//        InputStream in = new FileInputStream("D:\\test.txt");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//        String str = bufferedReader.readLine();

        String urlName = "http://gly-dev-gdoc.oss-cn-shanghai.aliyuncs.com/object/50/65693e3ca64d5e811570deab56d219?Expires=1495884357&OSSAccessKeyId=W15XWpaVWekTzVUW&Signature=iwoIpjDSwfY55USJf%2B/8fVhU2Aw%3D&response-content-disposition=attachment%3Bfilename%3D%22sql.txt%22";
        URL realUrl = new URL(urlName);
        URLConnection connection = realUrl.openConnection();
        connection.connect();
        Map<String, List<String>> map = connection.getHeaderFields();
        String fileName = map.get("Content-Disposition").get(0).split(";")[1].split("=")[1].replace("\"", "");
        Integer length = Integer.valueOf(map.get("Content-Length").get(0));


        byte[] buffer = new byte[length];
        //connection.getInputStream().read(buffer);
        //File file = new File("D:/down/"+"sql.txt");
        File file = new File("D:/down/" + fileName);
        if(!file.exists())
            file.createNewFile();

        //FileOutputStream outputStream = new FileOutputStream("D:/down/"+"sql.txt");
        FileOutputStream outputStream = new FileOutputStream("D:/down/"+ fileName);
        outputStream.write(buffer);

        outputStream.close();


    }
}
