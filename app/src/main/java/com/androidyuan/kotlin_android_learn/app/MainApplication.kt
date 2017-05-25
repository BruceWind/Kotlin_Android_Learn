package com.androidyuan.kotlin_android_learn.app

import android.app.Application

/**
 * Created by wei on 17-5-25.==
 * ================单例模式的 application==============
 */
class MainApplication : Application() {

    companion object {
        private var sInstance: MainApplication?= null
    }


    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }
}