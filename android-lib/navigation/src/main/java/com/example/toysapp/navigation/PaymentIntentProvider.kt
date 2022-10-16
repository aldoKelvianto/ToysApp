package com.example.toysapp.navigation

import android.content.Context
import android.content.Intent

interface PaymentIntentProvider {

    fun getPaymentIntent(context: Context, paymentGateway: String): Intent
}
