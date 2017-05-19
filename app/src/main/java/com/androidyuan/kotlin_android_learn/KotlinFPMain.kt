package com.androidyuan.kotlin_android_learn

import com.androidyuan.kotlin_android_learn.core.CoreLogger
import java.util.*

/**
 * Created by wei on 17-5-19.
 * ======函数式编程=======
 */
class KotlinFPMain {


    companion object {
        val logger = CoreLogger.getLogger("KotlinFPMain")

        fun filter(): List<Int> {
            val litterList = arrayListOf<Int>(0,1,2,3,4,5,8,23,6,7,123,12,3,123,324,123)

            val filterList = litterList.filter{ it > 5 }

            logger.d(filterList.toString())
            println("KotlinFPMain")
            return filterList
        }

        fun sortList(litterList:List<Int>) : List<Int>{
            val list =  litterList.sorted()
            logger.d(list.toString())
            println("KotlinFPMain")
            return list
        }



        fun main()
        {
            val filterList = filter()
            val sortlist = sortList(filterList)

        }
    }



}