package com.example.toysapp.logcat_logger;

import android.util.Log;

import com.example.toysapp.logger.Logger;

import org.jetbrains.annotations.NotNull;

public final class LogcatLogger implements Logger {

    private static final String TAG = "LogcatLogger";

    @Override
    public void log(@NotNull String message) {
        Log.d(TAG, "Log from LogcatLogger: " + message);
    }
}