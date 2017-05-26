package com.androidyuan.kotlin_android_learn

import com.androidyuan.kotlin_android_learn.core.CoreLogger

/**
 * Created by wei on 17-5-26.
 * =====测试when语法=====
 */
class WhenIFTest {

    companion object{
        fun main() {

            val index=3;

            when(index){
                1 -> {}
                2 -> {}
                3 -> {
                    CoreLogger.getLogger("WhenIFTest").d("index = "+index)
                }
            }

            val doubleindex = when(index){
                1 -> 1
                else -> {
                    index * 2
                }
            }

            CoreLogger.getLogger("WhenIFTest").d("double = "+doubleindex)


            val cost = when(doubleindex) {
                in 1..10 -> "cheap"
                in 10..100 -> "regular"
                in 100..1000 -> "expensive"
                else -> "not rated"
            }

            CoreLogger.getLogger("WhenIFTest").d("cost = "+cost)

            val ifvlue = if (doubleindex > 2) true else false
            CoreLogger.getLogger("WhenIFTest").d("ifvlue = "+ifvlue)

            for(i in 0..10)
            {
                CoreLogger.getLogger("WhenIFTest").d("i = "+i)
            }

            for(i in 10 downTo 0)
            {
                CoreLogger.getLogger("WhenIFTest").d("i = "+i)
            }
        }
    }
}