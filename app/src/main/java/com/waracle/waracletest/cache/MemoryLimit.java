package com.waracle.waracletest.cache;

public class MemoryLimit {

    public int size() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        return maxMemory / 8;
    }
}
