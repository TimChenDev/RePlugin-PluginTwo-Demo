package com.devtimchentw.replugin_plugintwo_demo

import android.app.Application
import android.util.Log
import com.qihoo360.replugin.RePlugin

/**
 *  author: Tim Chen
 *  time  : 2020-07-23
 *  desc  :
 */
@Suppress("unused")
class TwoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.v("AidlTest", "App onCreate")
        // Application 啟動時, 初始化 Binder, 並且註冊名稱 ITwo
        RePlugin.registerPluginBinder("ITwo", TwoListenerImpl())
    }
}