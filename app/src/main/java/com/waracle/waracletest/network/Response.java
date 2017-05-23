package com.waracle.waracletest.network;

public class Response {
    private byte[] bytes;
    private int code;

    public byte[] bytes() {
        return bytes;
    }

    public int code() {
        return code;
    }

    public Response(byte[] bytes, int code) {
        this.bytes = bytes;
        this.code = code;
    }
}