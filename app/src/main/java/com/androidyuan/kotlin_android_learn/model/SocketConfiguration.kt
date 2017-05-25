package com.androidyuan.kotlin_android_learn.model

/**
 * Created by wei on 17-5-25.
 * ======从Map中映射值来定义一个类======
 */
class SocketConfiguration(map:Map<String,Any?>) {

    val time_out:Int by map

    val trycount:Int by map

    val ip:String by map
    val port:Int by map
}