package com.example.toysapp.feature_payment

import android.content.Context
import android.content.Intent
import com.example.toysapp.navigation.PaymentIntentProvider

class FeatureModulePaymentIntentProvider : PaymentIntentProvider {

    override fun getPaymentIntent(context: Context, paymentGateway: String): Intent {
        return Intent(context, PaymentActivity::class.java).apply {
            putExtra(PaymentActivity.KEY_PAYMENT_GATEWAY, paymentGateway)
        }
    }
}
