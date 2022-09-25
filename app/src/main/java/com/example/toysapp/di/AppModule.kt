package com.example.toysapp.di

import com.example.toysapp.console_logger.ConsoleLogger
import com.example.toysapp.crypto.Encoding
import com.example.toysapp.crypto.Hashing
import com.example.toysapp.feature_payment.FeatureModulePaymentIntentProvider
import com.example.toysapp.logcat_logger.LogcatLogger
import com.example.toysapp.navigation.PaymentIntentProvider
import org.koin.dsl.module

val appModule = module {
    single<PaymentIntentProvider> {
        FeatureModulePaymentIntentProvider()
    }
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
