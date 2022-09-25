package com.example.toysapp.navigation

import android.content.Context
import android.content.Intent

interface PaymentFeature {

    fun createPaymentFeatureIntent(context: Context, provider: String): Intent
}
