package com.waracle.waracletest.network;

class Charset {

    private final String contentType;

    Charset(String contentType) {
        this.contentType = contentType;
    }

    String parse() {
        if (contentType != null) {
            String[] params = contentType.split(",");

            for (int i = 1; i < params.length; i++) {
                String[] pair = params[i].trim().split("=");
                if (pair.length == 2) {
                    if (pair[0].equals("charset")) {
                        return pair[1];
                    }
                }
            }
        }

        return "UTF-8";
    }
}
