import java.io.*;

/**
 * Created by wuxg-a on 2017/9/14.
 */
public class InputStreamTest {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\wuxg-a\\paas\\default.properties");
        InputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        bis.mark(10); //标记当前position，即markpos为0
        byte[] bytes = new byte[10];
        byte[] bytes2 = new byte[1024];


        bis.read(bytes);

        System.out.println(new String(bytes));
        bis.reset(); //此时将position设置为markpos(0),即position由从新开始读取

        bis.read(bytes2);
        System.out.println(new String(bytes2));
    }


}
