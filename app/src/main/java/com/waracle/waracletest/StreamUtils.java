package com.waracle.waracletest;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtils {

    // Can you see what's wrong with this???
    static byte[] read(InputStream inputStream) throws IOException {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024];

        int length;
        while ((length = inputStream.read(bytes, 0, bytes.length)) != -1) {
            buffer.write(bytes, 0, length);
        }

        return buffer.toByteArray();
    }

    static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception ignored) { }
    }
}
