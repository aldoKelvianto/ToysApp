package com.example.toysapp.feature_payment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toysapp.crypto.Base64Util
import com.example.toysapp.crypto.HashHelper
import com.example.toysapp.logger.Logger
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.get

class PaymentActivity : ComponentActivity() {

    private val logger: Logger by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.log("PaymentActivity - onCreate")

        val provider = intent.getStringExtra(KEY_PAYMENT_GATEWAY) ?: "Empty Provider"
        setContent {
            Content(provider, ::launchToyActivity)
        }
    }

    private fun launchToyActivity() {
        val action = "com.example.toysapp.launch.toy.activity"
        // packageName is the application id, so the value is
        // com.example.toysapp , not com.example.toysapp.feature_payment
        val packageName = this.packageName
        val intent = Intent(action).apply {
            setPackage(packageName)
            putExtra("key_name", "Rubber Duck")
        }
        startActivity(intent)
    }

    companion object {
        const val KEY_PAYMENT_GATEWAY = "key_payment_gateway"
    }
}

@Composable
fun Content(
    provider: String = "Default Payment Gateway",
    onToyButtonClick: () -> Unit = {},
    hashHelper: HashHelper = get(),
    base64Util: Base64Util = get()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "This is Payment Activity. Payment Gateway: $provider")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onToyButtonClick) {
            Text("Go to Toy Activity")
        }
        Spacer(modifier = Modifier.height(32.dp))

        var hashText by remember {
            mutableStateOf("This is hash result")
        }
        Text(text = hashText)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            hashText = hashHelper.md5Hash(provider)
        }) {
            Text("Hash Provider")
        }
        Spacer(modifier = Modifier.height(32.dp))

        var base64Text by remember {
            mutableStateOf("This is base64 encode result")
        }
        Text(text = base64Text)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            base64Text = base64Util.encodeToBase64(provider)
        }) {
            Text("Base64 Encode Provider")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    Content()
}

