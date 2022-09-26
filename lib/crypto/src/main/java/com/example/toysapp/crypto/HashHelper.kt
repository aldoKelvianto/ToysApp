package com.example.toysapp.crypto

import com.example.toysapp.logger.Logger
import org.apache.commons.codec.digest.Md5Crypt
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HashHelper : KoinComponent {

    private val logger: Logger by inject()

    fun md5Hash(text: String): String {
        logger.log("HashHelper - md5Hash")
        return Md5Crypt.md5Crypt(text.toByteArray())
    }
}
