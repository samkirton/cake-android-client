package com.waracle.waracletest.network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Load {

    private final URL url;

    public Load(URL url) {
        this.url = url;
    }

    public String fetch() throws IOException {
        final String body;
        final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            body = new String(
                    new StreamBytes(in).read(),
                    new Charset(urlConnection.getRequestProperty("Content-Type")).parse()
            );

        } finally {
            urlConnection.disconnect();
        }

        return body;
    }
}