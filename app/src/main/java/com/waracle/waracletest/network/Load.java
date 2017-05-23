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
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            body = new Response(
                    new StreamBytes(in).read(),
                    urlConnection.getResponseCode()
            );

        } finally {
            urlConnection.disconnect();
        }

        return body;
    }
}