package com.wxg.workspace;

/**
 * Created by wuxg-a on 2017/3/24.
 */
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.JsonParser;


public class OkHttpClientUtil {

    final static int TIME_OUT_THRESHOLD= 6000;
    private static Logger log = Logger.getLogger(OkHttpClientUtil.class.getName());

    public static void sendRequest(String url , String token){
        long startTime = System.currentTimeMillis();
        OkHttpClient client =  new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Authorization", String.format("Bearer %s" , token))
                .addHeader("Content-type", "application/json")
                .build();
        try {

            Response response = client.newCall(request).execute();
            long endTime = System.currentTimeMillis();
            long responseTime = endTime-startTime;
            log.info("当前请求耗时：" + responseTime + "ms");
            log.info("response:" + response.body().string());
            if(responseTime > TIME_OUT_THRESHOLD){
                _writeData(0 , "当前请求超时,耗时：" + responseTime + "ms");
            }else if(response.code() == 200 && responseTime < TIME_OUT_THRESHOLD){
                _writeData(3 , "当前请求正常,耗时：" + responseTime + "ms");
            }else if(response.code() != 200 && responseTime < TIME_OUT_THRESHOLD){
                _writeData(1 , "当前请求错误,code：" + response.code() + "message:" + response.body().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                _writeData(2 , "异常信息：" + e.getMessage().toString());
            } catch (IOException e1) {
            }
        }

    }
    public static String _getToken() throws UnsupportedEncodingException {
        String token = "";
        String passWord = "123gbq!@#";
        passWord = URLEncoder.encode(passWord, "UTF-8");
        String url = "https://account.glodon.com/oauth2/token?grant_type=password&username=gcloudmonitor@126.com&password=" + passWord;
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Authorization", String.format("Basic %s", "UTRtOEl2NVFaYmoyYWhhaFl6Mk1wOVJEQ3VXMVdaMEc6ckx1Uno2bDZxWTNOdVhtYk53eHdzUmZMMnh1dWxhVkU="))
                .addHeader("Content-type", "application/json")
                .build();

            try {
                Response response = client.newCall(request).execute();
                token = _parseJson(response.body().string());
                log.info("获取Token：" + token);
                return  token;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return token;
    }
    private static String _parseJson(String data){
        if(data == null)
            return "";
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject)parser.parse(data);
        String token = jsonObject.get("access_token").getAsString();
        return token;
    }

    private static void _writeData(int sheetNum , String message) throws IOException{
        FileInputStream fs = new FileInputStream(new File("f:\\getworkspace.xls"));
        POIFSFileSystem ps=new POIFSFileSystem(fs);
        HSSFWorkbook wb=new HSSFWorkbook(ps);
        HSSFSheet sheet=wb.getSheetAt(sheetNum);
        HSSFRow row = sheet.createRow((short)(sheet.getLastRowNum()+1));

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date=new java.util.Date();
        String str=sdf.format(date);
        row.createCell(0).setCellValue(str); //记录当前时间

        row.createCell(1).setCellValue(message); //记录信息

        FileOutputStream out=new FileOutputStream("f:\\getworkspace.xls");
        wb.write(out);
        out.close();
    }
    public static void  _getDataToExecel() throws IOException{
        HSSFWorkbook workbook = null;
        workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet1");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("f:\\getworkspace.xls"));
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

