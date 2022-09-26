package com.example.toysapp.di

import com.example.toysapp.console_logger.ConsoleLogger
import com.example.toysapp.crypto.Base64Util
import com.example.toysapp.crypto.HashHelper
import com.example.toysapp.feature_payment.FeatureModulePaymentIntentProvider
import com.example.toysapp.feature_payment.PaymentActivity
import com.example.toysapp.feature_toys.ToysActivity
import com.example.toysapp.logcat_logger.LogcatLogger
import com.example.toysapp.logger.Logger
import com.example.toysapp.navigation.PaymentIntentProvider
import org.koin.dsl.module

val appModule = module {
    scope<ToysActivity> {
        scoped<Logger> {
            LogcatLogger()
        }
        scoped<PaymentIntentProvider> {
            FeatureModulePaymentIntentProvider()
        }
    }
    scope<PaymentActivity> {
        scoped<Logger> {
            ConsoleLogger()
        }
    }
    scope<HashHelper> {
        scoped<Logger> {
            ConsoleLogger()
        }
    }
    scope<Base64Util> {
        scoped<Logger> {
            LogcatLogger()
        }
    }
}
