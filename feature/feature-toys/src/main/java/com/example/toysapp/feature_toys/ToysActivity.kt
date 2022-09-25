package com.example.toysapp.feature_toys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toysapp.navigation.PaymentIntentProvider
import org.koin.android.ext.android.inject

class ToysActivity : ComponentActivity() {

    private val paymentIntentProvider: PaymentIntentProvider by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.extras?.getString(KEY_NAME) ?: "Empty Name"
        setContent {
            Content(name, ::launchPaymentActivity)
        }
    }

    private fun launchPaymentActivity() {
        val intent = paymentIntentProvider.providePaymentIntent(this, "Stripe")
        startActivity(intent)
    }

    companion object {
        const val KEY_NAME = "key_name"
    }
}

@Composable
fun Content(
    name: String = "Empty name",
    onPaymentButtonClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("This is Toys Activity")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onPaymentButtonClick) {
            Text("Go to Payment Activity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    Content()
}
