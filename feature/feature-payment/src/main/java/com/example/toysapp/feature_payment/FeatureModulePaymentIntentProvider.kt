package com.example.toysapp.feature_payment

import android.content.Context
import android.content.Intent
import com.example.toysapp.navigation.PaymentIntentProvider

class FeatureModulePaymentIntentProvider : PaymentIntentProvider {

    override fun providePaymentIntent(context: Context, provider: String): Intent {
        return Intent(context, PaymentActivity::class.java).apply {
            putExtra(PaymentActivity.KEY_PROVIDER, provider)
        }
    }
}
