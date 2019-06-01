package com.usfot.bookzc.utils;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zc
 * @create 2019-05_31-12:01
 */
public class BookUtil {

    public void bookPictureDown(String pictureUrl) throws IOException {
        URL url = new URL(pictureUrl);
        InputStream inputStream = url.openStream();
        byte[] b = new byte[1024];
        int len = inputStream.available();
        inputStream.read(b, 0, len);
        FileOutputStream fileOutputStream = new FileOutputStream("/pic/book/");
    }

}
