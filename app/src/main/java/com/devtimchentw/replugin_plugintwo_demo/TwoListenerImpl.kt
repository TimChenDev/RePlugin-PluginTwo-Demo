package com.devtimchentw.replugin_plugintwo_demo

import android.util.Log
import com.devtimchentw.remote.TwoListener
import com.devtimchentw.remote.TwoToOne

/**
 *  author: Tim Chen
 *  time  : 2020-07-23
 *  desc  :
 *
 *  實現 TwoListener 的 binder
 *  實作 TwoListener 的 function
 *  初始化的時機點為 TwoApplication 的 onCreate
 */
class TwoListenerImpl : TwoListener.Stub() {

    /**
     * 實現 talkToTwo 要做的事情
     */
    override fun talkToTwo(message: String?, tto: TwoToOne?) {
        Log.v(
            "AidlTest",
            "PluginTwo >> TwoListenerImpl >> 收到 外部的通知, 傳來一個 message: $message, 與一個 tto"
        )

        doSomething()

        // PluginTwo 做完事情了, 通知 PluginOne
        tto?.backFromTwo("PluginTwo 做完事情了, 通知 PluginOne")
    }

    private fun doSomething() {
        Log.v("AidlTest", "PluginTwo >> TwoListenerImpl >> doSomething()")

        for (i in 0..999) {
            Log.v("AidlLogV", "PluginTwo >> TwoListenerImpl >> i: $i")
        }

        Log.v("AidlTest", "PluginTwo >> TwoListenerImpl >> doSomething() 完成, 透過 tto 通知 PluginOne")
    }
}