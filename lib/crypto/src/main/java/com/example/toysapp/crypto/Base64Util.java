package com.example.toysapp.crypto;

import com.example.toysapp.logger.Logger;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {

    private final Logger logger;

    public Base64Util(Logger logger) {
        this.logger = logger;
    }

    public String encodeToBase64(String text) {
        logger.log("EncoderUtil - encodeToBase64");

        Base64 base64 = new Base64();
        byte[] encodedBytes = base64.encode(text.getBytes());
        return new String(encodedBytes);
    }
}
