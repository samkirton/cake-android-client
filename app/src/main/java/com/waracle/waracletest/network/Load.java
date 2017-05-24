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

    public Response fetch() throws IOException {
        final Response body;
        final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            int code = urlConnection.getResponseCode();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            if (code == HttpURLConnection.HTTP_MOVED_TEMP ||
                    code == HttpURLConnection.HTTP_MOVED_PERM) {
                return new Load(new URL(urlConnection.getHeaderField("Location"))).fetch();
            } else {
                body = new Response(
                        new StreamBytes(in).read(),
                        code
                );
            }

        } finally {
            urlConnection.disconnect();
        }

        return body;
    }
}