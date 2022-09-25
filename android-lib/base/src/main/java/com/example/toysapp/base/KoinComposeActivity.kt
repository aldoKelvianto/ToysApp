package com.example.toysapp.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.createActivityRetainedScope
import org.koin.core.scope.Scope

abstract class KoinComposeActivity : ComponentActivity(), AndroidScopeComponent {

    override var scope: Scope? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createActivityRetainedScope()
    }
}
