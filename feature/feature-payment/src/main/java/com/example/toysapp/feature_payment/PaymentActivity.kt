package com.example.toysapp.feature_payment

import android.content.Context
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
import com.example.toysapp.navigation.PaymentFeature

class PaymentActivity: ComponentActivity(), PaymentFeature {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val provider = intent.getStringExtra(KEY_PROVIDER) ?: "Empty Provider"
        setContent {
            Content(provider, ::launchToyActivity)
        }
    }

    override fun createPaymentFeatureIntent(context: Context, provider: String): Intent {
        return Intent(context, this::class.java).apply {
            putExtra(KEY_PROVIDER, provider)
        }
    }

    private fun launchToyActivity() {
        val action = "com.example.toysapp.launch.toy.activity"
        // packageName is the application id, so the value is
        // com.example.toysapp , not com.example.toysapp.feature_payment
        val packageName = this.packageName
        val intent = Intent(action).apply {
            setPackage(packageName)
        }
        startActivity(intent)
    }

    companion object {
        const val KEY_PROVIDER = "key_provider"
    }
}

@Composable
fun Content(
    provider: String = "Empty Provider",
    onToyButtonClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "This is Payment Activity. Provider: $provider")
        Spacer(modifier = Modifier.height(18.dp))
        Button(onClick = onToyButtonClick) {
            Text("Go to Toy Activity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    Content()
}

