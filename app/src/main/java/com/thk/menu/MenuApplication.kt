package com.thk.menu

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompatApplication

class MenuApplication : SplitCompatApplication() {

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        context = this
    }
}