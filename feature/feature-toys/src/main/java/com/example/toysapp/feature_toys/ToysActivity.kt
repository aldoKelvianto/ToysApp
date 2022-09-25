package com.example.toysapp.feature_toys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text

class ToysActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.extras?.get(KEY_NAME) ?: "Empty Name"
        setContent {
            Text(
                text = "This is Toys Activity. Name: $name"
            )
        }
    }

    companion object {
        const val KEY_NAME = "key_name"
    }
}
