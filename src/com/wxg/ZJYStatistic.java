package com.wxg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxg-a on 2019/2/21.
 */
public class ZJYStatistic {

    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\wuxg-a\\Desktop\\造价云统计\\zaojiayun_导出数据\\personal_workspace.txt");
        File file2 = new File("C:\\Users\\wuxg-a\\Desktop\\造价云统计\\zaojiayun_导出数据\\out\\personal_workspace.sql");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file2);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        String wsid = null;
        int count = 0;
        List<String> wsids = new ArrayList<>();

        while ((wsid = br.readLine()) != null) {
            wsids.add(wsid);
        }

        StringBuilder sb = new StringBuilder("insert into `zjy_personal_wsid` (`wsid`) values ");
        for (String _wsid : wsids) {
            sb.append("('").append(_wsid).append("'),");
            if (++count == 5000) {
                sb.replace(sb.length() - 1, sb.length(), ";");
                bw.newLine();
                bw.write(sb.toString());
                sb = new StringBuilder("insert into `zjy_personal_wsid` (`wsid`) values ");
                count = 0;
            }
        }
        sb.replace(sb.length() - 1, sb.length(), ";");
        bw.newLine();
        bw.write(sb.toString());
        bw.flush();
        System.out.println(sb.toString());
        System.out.println(wsids.size());

    }
}
