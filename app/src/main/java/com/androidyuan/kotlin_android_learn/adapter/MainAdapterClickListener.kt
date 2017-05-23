package com.androidyuan.kotlin_android_learn.adapter

/**
 * Created by wei on 17-5-23.
 * =====测试操作符重载=====
 */
interface MainAdapterClickListener {
    operator fun invoke(index:Int);
}