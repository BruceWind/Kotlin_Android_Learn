package com.androidyuan.kotlin_android_learn.app

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by wei on 17-5-25.==
 * ================单例模式的 application==============
 */
class MainApplication : Application() {

    companion object {
        //private var sInstance: MainApplication?= null
        private var sInstance: MainApplication by Delegates.notNull()//使用 notNull 委托:访问时如果空就会抛异常

        fun getInstance():MainApplication{
            return sInstance;
        }
    }


    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }
}