import org.apache.commons.lang3.StringUtils;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wuxg-a on 2017/7/24.
 */
public class FinalTest {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
//        URL Url1 = new URL("http://gly-dev-gdoc.oss-cn-shanghai.aliyuncs.com/object/0b/3c0c6eff824fb096311283b6ca55a7?Expires=1503291045&OSSAccessKeyId=W15XWpaVWekTzVUW&Signature=KcSCOlEnaVKGdAZDbBA%2BdNVarCk%3D&response-content-disposition=attachment%3Bfilename%3D%22test.mp4%22");
//
//        URL url2 = new URL("https://gly-dev-gdoc.oss-cn-shanghai.aliyuncs.com/object/b4/5e1072b35745b7a15ed9ad48708e8a?Expires=1503055371&OSSAccessKeyId=W15XWpaVWekTzVUW&Signature=Dso274ySRazD6x5ZSQidICCtk%2BA%3D&response-content-disposition=attachment%3Bfilename%3D%22%25E5%25B9%25BF%25E8%2581%2594%25E8%25BE%25BE%25E5%25AE%25A3%25E4%25BC%25A0%25E7%2589%25872016-10-18.mp4%22");
//        FrameRunnable task1 = new FrameRunnable(Url1,"2000", 96, 96);
//        Thread t1 = new Thread(task1);
//        t1.setName("Thread-Task1");
//        t1.start();
        int[][] t_size = new int[][]{
                {96, 96}, {64, 64}, {32, 32}
        };
        for(int i=0; i<t_size.length; i++){
            System.out.println(t_size[i][0] + "," +t_size[i][1]);
        }

//        FrameRunnable task2 = new FrameRunnable(Url2, "3600", 36, 36);
//        Thread t2 = new Thread(task2);
//        t2.setName("Thread-Task2");
//        t2.start();

//        FrameRunnable task3 = new FrameRunnable("19", 50, 50);
//        Thread t3 = new Thread(task3);
//        t3.setName("Thread-Task3");
//        t3.start();
//
//        for(int i=0; i<1000; i++){
//            Thread.sleep(1000);
//        }

//        String videoRealPath = "F:\\thunnailTest\\test.MP4";
//        //截图的路径（输出路径）
//        String imageRealPath ="F:\\thunnailTest\\a.jpg";
//        try {
//            //调用批处理文件
//            Runtime.getRuntime().exec("cmd /c start F:\\thunnailTest\\ffmpeg.bat " + videoRealPath + " " + imageRealPath);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }


}
