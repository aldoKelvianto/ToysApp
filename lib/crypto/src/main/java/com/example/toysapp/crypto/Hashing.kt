package com.example.toysapp.crypto

import com.example.toysapp.logger.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Hashing: KoinComponent {

    private val logger: Logger by inject()
}
