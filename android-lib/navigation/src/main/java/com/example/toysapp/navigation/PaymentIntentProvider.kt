package com.example.toysapp.navigation

import android.content.Context
import android.content.Intent

interface PaymentIntentProvider {

    fun providePaymentIntent(context: Context, provider: String): Intent
}
