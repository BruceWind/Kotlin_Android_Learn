package com.androidyuan.kotlin_android_learn

import com.androidyuan.kotlin_android_learn.core.CoreLogger

/**
 * Created by wei on 17-5-26.
 * =====测试when语法=====
 */
class WhenTest {

    companion object{
        fun main() {

            val index=3;

            when(index){
                1 -> {}
                2 -> {}
                3 -> {
                    CoreLogger.getLogger("WhenTest").d("index = "+3)
                }
            }
        }
    }
}