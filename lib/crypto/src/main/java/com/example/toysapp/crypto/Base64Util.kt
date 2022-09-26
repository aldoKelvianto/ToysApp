package com.example.toysapp.crypto

import com.example.toysapp.logger.Logger
import org.apache.commons.codec.binary.Base64

class Base64Util(
    private val logger: Logger
) {

    fun encodeToBase64(text: String): String {
        logger.log("EncoderUtil - encodeToBase64")

        val base64 = Base64()
        val encodedBytes = base64.encode(text.toByteArray())
        return String(encodedBytes)
    }
}
