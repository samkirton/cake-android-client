package com.waracle.waracletest.async;

public class Result {
    private final String body;
    private final boolean success;

    public String getBody() {
        return body;
    }

    public boolean success() {
        return success;
    }

    public Result(String body, boolean success) {
        this.body = body;
        this.success = success;
    }
}