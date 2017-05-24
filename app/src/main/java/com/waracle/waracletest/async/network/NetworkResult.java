package com.waracle.waracletest.async.network;

public class NetworkResult {
    private final String body;
    private final int code;

    public String getBody() {
        return body;
    }

    public boolean success() {
        return code >= 200 && code < 300;
    }

    NetworkResult(String body, int code) {
        this.body = body;
        this.code = code;
    }
}