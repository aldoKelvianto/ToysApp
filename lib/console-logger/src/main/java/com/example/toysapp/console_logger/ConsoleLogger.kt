package com.example.toysapp.console_logger

import com.example.toysapp.logger.Logger

class ConsoleLogger : Logger {

    override fun log(message: String) {
        println("Log from ConsoleLogger: $message")
    }
}
