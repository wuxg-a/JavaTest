package com.wxg.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wuxg-a on 2018/10/12.
 */
public class MyList {
    public static void main(String[] args) {
            String fileName = "001-7#栋大堂地面镜面处理完成 .jpg";
            String suffix = StringUtils.substring(fileName, fileName.lastIndexOf('.') + 1);
            suffix = suffix.toLowerCase();

            System.out.println(suffix);
    }
}
