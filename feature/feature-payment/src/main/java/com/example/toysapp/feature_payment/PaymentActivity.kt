package com.example.toysapp.feature_payment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.toysapp.navigation.PaymentFeature

class PaymentActivity: ComponentActivity(), PaymentFeature {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val provider = intent.getStringExtra(KEY_PROVIDER) ?: "Empty Provider"
        setContent {
            Text(text = "This is Payment Activity. Provider: $provider")
        }
    }

    override fun createPaymentFeatureIntent(context: Context, provider: String): Intent {
        return Intent(context, this::class.java).apply {
            putExtra(KEY_PROVIDER, provider)
        }
    }

    companion object {
        const val KEY_PROVIDER = "key_provider"
    }
}
