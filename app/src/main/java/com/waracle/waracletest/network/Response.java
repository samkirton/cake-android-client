package com.waracle.waracletest.network;

public class Response {
    private final byte[] bytes;
    private final int code;

    public byte[] bytes() {
        return bytes;
    }

    public int code() {
        return code;
    }

    Response(byte[] bytes, int code) {
        this.bytes = bytes;
        this.code = code;
    }
}