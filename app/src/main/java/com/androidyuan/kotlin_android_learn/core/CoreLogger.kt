package com.androidyuan.kotlin_android_learn.core

import android.content.Context
import android.util.Log

import java.lang.reflect.Field

/**
 * Copyright (c) 2016. BiliBili Inc.
 * Created by wei on 17-2-20 ,email:602807247@qq.com
 * .
 * =====Log专用类==========
 * 这种方案不太好，其实可以通过建立gradle task的方式删除 Log代码
 * .
 * ******************************规范：规范**************************
 * 1.一定要使用.d()或者info()
 * 2.其他的方法不会在正式版本的app中隐藏日志
 */

class CoreLogger {


    private var TAG = " " + this.javaClass.simpleName


    constructor() {

    }

    constructor(s: String) {
        TAG = s
    }

    /**
     * 自动判断当前apk是否为正式版本

     * @param s, if release version will output,else not output.
     */
    fun d(s: String) {
        if (mIsDebug) {
            Log.d(TAG, s + "")
        }
    }

    fun w(s: String) {
        Log.w(TAG, s + "")
    }


    fun e(s: String) {
        Log.e(TAG, s + "")
    }


    fun e(throwable: Throwable) {
        Log.wtf(TAG, throwable)
    }

    fun info(s: String) {
        Log.i(TAG, s)
    }

    fun warning(s: String) {
        Log.w(TAG, s)
    }

    companion object {

        private var mIsDebug = true

        /**
         * 不用在主工程调用initLogger了  自动取主工程的 BuildConfig

         * @param isDebug
         */
        private fun initLogger(isDebug: Boolean) {
            mIsDebug = isDebug
            CoreLogger().d(" isDebug = " + isDebug)
        }

        //虚基类不推荐使用这个方法,因为通过getClas很取不到类名
        fun getLogger(obj: Any): CoreLogger {
            return CoreLogger(" " + obj.javaClass.simpleName)
        }

        fun getLogger(s: String): CoreLogger {
            return CoreLogger(s)
        }

        /**
         * 不用在主工程调用initLogger了  自动取主工程的 BuildConfig
         * 因为主项目的 BuildConfig类名肯定是可以动态获取的
         */
        fun initDebugConfig(context: Context) {
            var cls: Class<*>? = this.javaClass
            try {
                //动态获取BuildConfig
                CoreLogger()
                        .d(context.applicationContext.packageName + ".BuildConfig")
                cls = getBuildConfig(context.applicationContext.packageName + ".BuildConfig")
                if (cls == null) return

                val field = cls.getField("DEBUG")
                val isDebug = field.getBoolean(null)
                CoreLogger.initLogger(isDebug)
            } catch (e: NoSuchFieldException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }

        }

        private fun getBuildConfig(clsname: String): Class<*> {
            var cls: Class<*> = Any::class.java
            try {
                cls = Class.forName(clsname)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }

            return cls
        }
    }

}
