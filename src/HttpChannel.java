import org.apache.commons.logging.Log;
import org.jcodec.common.io.SeekableByteChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

import java.io.IOException;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by wuxg-a on 2017/8/16.
 */
public class HttpChannel implements SeekableByteChannel {
    private static final String LOG_TAG_HTTP_CHANNEL = "HttpChannel";
    private final Logger Logger = LoggerFactory.getLogger(this.getClass());
    private URL url;
    private ReadableByteChannel ch;
    private long pos;
    private long length;

    private long count = 0;
    private long accessHttpInputStreamCount = 0;
    private long times = 0;

    public HttpChannel(URL url) {
        this.url = url;
    }

    @Override
    public long position() throws IOException {
        return pos;
    }

    @Override
    public SeekableByteChannel setPosition(long newPosition) throws IOException {
        if (newPosition == pos)
            return this;
        if (ch != null) {
            ch.close();
            ch = null;
        }
        pos = newPosition;
        Logger.info(LOG_TAG_HTTP_CHANNEL, " Seeking to: " + newPosition);
        return this;
    }

    @Override
    public long size() throws IOException {
        return length;
    }

    @Override
    public SeekableByteChannel truncate(long size) throws IOException {
        throw new IOException("Truncate on HTTP is not supported.");
    }

    @Override
    public int read(ByteBuffer buffer) throws IOException {
        ensureOpen();
        int read = ch.read(buffer);
        count += read;
        if (read != -1)
            pos += read;
        Logger.info(LOG_TAG_HTTP_CHANNEL + "---------------->" + " count:" + count);
        Logger.info(LOG_TAG_HTTP_CHANNEL + "---------------->" + " count:" + accessHttpInputStreamCount++);
        return read;
    }

    @Override
    public int write(ByteBuffer buffer) throws IOException {
        throw new IOException("Write to HTTP is not supported.");
    }

    @Override
    public boolean isOpen() {
        return ch != null && ch.isOpen();
    }

    @Override
    public void close() throws IOException {
        ch.close();
    }

    private void ensureOpen() throws IOException {
        if (ch == null) {
            URLConnection connection = url.openConnection();
            Logger.info(LOG_TAG_HTTP_CHANNEL + "--------------> URLConnection times:" + times++);
            if (pos > 0) {
                connection.addRequestProperty("Range", "bytes=" + pos + "-");
                Logger.info(LOG_TAG_HTTP_CHANNEL + "Range", "bytes=" + pos + "-");
            }
            ch = Channels.newChannel(connection.getInputStream());
            String resp = connection.getHeaderField("Content-Range");
            if (resp != null) {
                Logger.info(LOG_TAG_HTTP_CHANNEL + " Content-Range: " + resp);
                length = Long.parseLong(resp.split("/")[1]);
            } else {
                resp = connection.getHeaderField("Content-Length");
                Logger.info(LOG_TAG_HTTP_CHANNEL + " Content-Length: " + resp);
                length = Long.parseLong(resp);
            }
        }
    }
}