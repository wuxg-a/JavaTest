package com.wxg.zip.extract.prop;

import com.glodon.paas.foundation.utils.unzip.SeekableHttpFileChanel;
import com.sun.deploy.net.HttpUtils;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wuxg-a on 2018/10/22.
 */
public class ZipExtractPropTest {

    public static void main(String[] args) {
//        String fileName = "G:" + File.separator + "testZipExtractProp" + File.separator + "test.zip";
//        Map<String, String> hashMap =  extractZipComment(fileName);
//        for(Map.Entry entry : hashMap.entrySet()){
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        String signedUrl = "https://gly-dev-gdoc.oss-cn-shanghai.aliyuncs.com/object/c8/7f30fa59a94e50973ad9ef2f9504ac?Expires=1541253087&OSSAccessKeyId=LTAIP9gxLRjd80Fl&Signature=AhFTRadNWb6ZAFlwaHRlaO/%2BjDs%3D&response-content-disposition=attachment%3Bfilename%3D%22test.zip%22";
        Map<String, String> hashMap = extractZipCommentFromStream1(signedUrl, 14369039);
        for(Map.Entry entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

//    public static Map<String, String> extractZipCommentFromStream1 (String signedUrl, int fileLength) {
//            String retStr = null;
//            try{
//                InputStream in = new URL(signedUrl).openStream();
//                byte[] buffer = new byte[Math.min(fileLength, 8192)];
//
//                int len;
//                in.skip(fileLength - buffer.length);
//                while((len = in.read(buffer)) > 0) {
//                    retStr = getZipCommentFromBuffer(buffer, len);
//                    System.out.println("--->" +retStr);
//                }
//                return _propToMap(retStr);
//            }catch (Exception e) {
//
//            }
//        return null;
//    }

    public static Map<String, String> extractZipCommentFromStream1 (String signedUrl, int fileLength) {
        String retStr = null;
        try{
            InputStream in = new URL(signedUrl).openStream();
            byte[] buffer_1024 = new byte[1024];
            byte[] buffer = new byte[Math.min(fileLength, 8192)];

            int len, count =0;
            in.skip(fileLength - buffer.length);
            while((len = in.read(buffer_1024)) > 0) {
                System.arraycopy(buffer_1024, 0, buffer, count, len);
                count += len;
            }
            retStr = getZipCommentFromBuffer(buffer, count);
            return _propToMap(retStr);
        }catch (Exception e) {

        }
        return null;
    }

    public static Map<String, String> extractZipCommentFromStream2 (String signedUrl, int fileLength) throws IOException {
        SeekableHttpFileChanel httpFileChanel = new SeekableHttpFileChanel(signedUrl, fileLength);
        ZipFile zipFile = new ZipFile(httpFileChanel);

//        try{
//            InputStream in = new InputStream() {
//                @Override
//                public int read() throws IOException {
//                    return zipFile.
//                }
//            };
//            byte[] buffer = new byte[Math.min(fileLength, 8192)];
//
//            int len;
//            in.skip(fileLength - buffer.length);
//            if ((len = in.read(buffer)) > 0) {
//                retStr = getZipCommentFromBuffer(buffer, len);
//            }
//            return _propToMap(retStr);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    //下载文件后提取
    public static Map<String, String> extractZipCommentFromStream (String signedUrl, int fileLength) {
        String retStr = null;
        try {

            String tmpPath = System.getProperty("user.home") +  File.separator + "zipProp" + File.separator + UUID.randomUUID().toString() + ".tmp";
            System.out.println(tmpPath);
            File tmpFile = new File(tmpPath);
            FileUtils.copyURLToFile(new URL(signedUrl), tmpFile);

            FileInputStream in = new FileInputStream(tmpFile);

            byte[] buffer = new byte[Math.min(fileLength, 8192)];
            int len;

            in.skip(fileLength - buffer.length);

            //if ((len = in.read(buffer)) > 0) {
            while((len = in.read(buffer)) > 0) {
                retStr = getZipCommentFromBuffer (buffer, len);
            }

            in.close();
            FileUtils.deleteQuietly(tmpFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _propToMap(retStr);
    }

    public static Map<String,String> extractZipComment (String filename) {
        String retStr = null;
        try {
            File file = new File(filename);
            int fileLen = (int)file.length();

            FileInputStream in = new FileInputStream(file);

            byte[] buffer = new byte[Math.min(fileLen, 8192)];
            int len;

            in.skip(fileLen - buffer.length);

            if ((len = in.read(buffer)) > 0) {
                retStr = getZipCommentFromBuffer (buffer, len);
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _propToMap(retStr);
    }

    private static String getZipCommentFromBuffer (byte[] buffer, int len) throws UnsupportedEncodingException {
        byte[] magicDirEnd = {0x50, 0x4b, 0x05, 0x06};
        int buffLen = Math.min(buffer.length, len);
        //Check the buffer from the end
        for (int i = buffLen-magicDirEnd.length-22; i >= 0; i--) {
            boolean isMagicStart = true;
            for (int k=0; k < magicDirEnd.length; k++) {
                if (buffer[i+k] != magicDirEnd[k]) {
                    isMagicStart = false;
                    break;
                }
            }
            if (isMagicStart) {
                //Magic Start found!
                int commentLen = buffer[i+20] + buffer[i+22]*256;
                int realLen = buffLen - i - 22;
                System.out.println ("ZIP comment found at buffer position " + (i+22) + " with len="+commentLen+", good!");
                if (commentLen != realLen) {
                    System.out.println ("WARNING! ZIP comment size mismatch: directory says len is "+
                            commentLen+", but file ends after " + realLen + " bytes!");
                }
                String comment = new String (buffer, i+22, Math.min(commentLen, realLen),"gbk");
                return comment;
            }
        }
        return null;
    }



    private static Map<String,String> _propToMap(String prop){
        Map<String, String> propMap = new HashMap<>();
        if(StringUtils.isBlank(prop)){
            return propMap;
        }
        String[] properties = prop.split("\r\n");
        propMap = Arrays.stream(properties)
                .filter(item -> item.contains("="))
                .collect(Collectors.toMap(item -> item.substring(0, item.indexOf('=')), item ->item.substring(item.indexOf('=') +1)));

        return propMap;


    }
}
