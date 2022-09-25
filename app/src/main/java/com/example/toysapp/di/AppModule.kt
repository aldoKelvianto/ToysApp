package com.example.toysapp.di

import com.example.toysapp.console_logger.ConsoleLogger
import com.example.toysapp.crypto.Encoding
import com.example.toysapp.crypto.Hashing
import com.example.toysapp.logcat_logger.LogcatLogger
import org.koin.dsl.module

val appModule = module {
    scope<Hashing> {
        scoped {
            ConsoleLogger()
        }
    }
    scope<Encoding> {
        scoped {
            LogcatLogger()
        }
    }
}
