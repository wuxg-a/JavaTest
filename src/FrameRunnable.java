import okhttp3.RequestBody;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.io.*;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by wuxg-a on 2017/8/16.
 */
public class FrameRunnable implements Runnable{

    private String FrameNum;
    private int width;
    private int height;
    private URL url;
    static final int [] video_thumbnail_size = {96, 64, 32};
    public FrameRunnable(String frameNum) {

        FrameNum = frameNum;
    }

    public FrameRunnable(URL url, String frameNum, int width, int height) {
        FrameNum = frameNum;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        try {
            FrameGrab frameGrab = FrameGrab.createFrameGrab(new TiledChannel(new HttpChannel(url)));
            frameGrab.seekToFramePrecise(Integer.parseInt(FrameNum));
            Picture picture = frameGrab.getNativeFrame();
            for (int i=0; i< video_thumbnail_size.length; i++){
                BufferedImage bufferedImage = resize(AWTUtil.toBufferedImage(picture), video_thumbnail_size[i], video_thumbnail_size[i]);
                File file = new File("F:\\thunnailTest\\" + "frame" + video_thumbnail_size[i] + ".jpg");
                ImageIO.write(bufferedImage, "jpg", file);
            }
            //BufferedImage bufferedImage = resize(AWTUtil.toBufferedImage(picture), width, height);
            //File file = new File("F:\\thunnailTest\\" + "frame" + FrameNum + ".jpg");
            //ImageIO.write(bufferedImage, "jpg", file);
            //int frameNum = Integer.parseInt(FrameNum);
            //Picture picture = frameGrab.getFrameFromFile(new File("F:\\thunnailTest\\test.MP4"), frameNum);
            //file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JCodecException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_3BYTE_BGR);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
