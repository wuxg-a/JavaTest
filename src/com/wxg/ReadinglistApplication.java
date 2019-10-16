package com.wxg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxg-a on 2019/7/22.
 */
public class ReadinglistApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
//		SpringApplication.run(ReadinglistApplication.class, args);

        File file = new File("G:\\A工作\\功能需求\\造价云数据统计\\ws_id\\ws_id.txt");
        File file2 = new File("G:\\A工作\\功能需求\\造价云数据统计\\ws_id\\ws_id.sql");
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
        int count_real = 0;
        for (String _wsid : wsids) {
            // trim
            if (_wsid == null || _wsid.length() == 0 || _wsid.trim().length() == 0 || _wsid.length() != 32) {
                continue;
            }
            count_real ++;
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
        bw.newLine();
        bw.write("END OF LINE");
        System.out.println(sb.toString());
        System.out.println(wsids.size());
        System.out.println("count_real: " + count_real);

    }
}
