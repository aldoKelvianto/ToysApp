package com.example.toysapp

import android.content.Intent
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
import com.example.toysapp.feature_payment.PaymentActivity
import com.example.toysapp.feature_toys.ToysActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content(::launchToyActivity, ::launchPaymentActivity)
        }
    }

    private fun launchToyActivity() {
        val intent = Intent(this, ToysActivity::class.java)
        startActivity(intent)
    }

    private fun launchPaymentActivity() {
        val intent = Intent(this, PaymentActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun Content(
    onToyButtonClick: () -> Unit = {},
    onPaymentButtonClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("This is Main Activity")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onToyButtonClick) {
            Text("Go to Toy Activity")
        }
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
