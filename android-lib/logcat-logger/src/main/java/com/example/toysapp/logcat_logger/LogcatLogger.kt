package com.example.toysapp.logcat_logger

import android.util.Log
import com.example.toysapp.logger.Logger

class LogcatLogger: Logger {

    override fun log(message: String) {
        Log.d(TAG, "Log from LogcatLogger: $message")
    }

    companion object {
        private const val TAG = "LogcatLogger"
    }
}
