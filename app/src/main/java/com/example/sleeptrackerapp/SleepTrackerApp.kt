package com.example.sleeptrackerapp

import android.app.Application
import androidx.emoji2.bundled.BundledEmojiCompatConfig
import androidx.emoji2.text.EmojiCompat

class SleepTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
        EmojiCompat.init(BundledEmojiCompatConfig(applicationContext))

    }
}