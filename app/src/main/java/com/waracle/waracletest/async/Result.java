package com.waracle.waracletest.async;

public class Result {
    private final String body;
    private final int code;

    public String getBody() {
        return body;
    }

    public boolean success() {
        return code >= 200 && code < 300;
    }

    Result(String body, int code) {
        this.body = body;
        this.code = code;
    }
}