package com.waracle.waracletest.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class StreamBytes {

    private final InputStream inputStream;

    StreamBytes(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    byte[] read() throws IOException {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024];

        int length;
        while ((length = inputStream.read(bytes, 0, bytes.length)) != -1) {
            buffer.write(bytes, 0, length);
        }

        return buffer.toByteArray();
    }
}
