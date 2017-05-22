package com.androidyuan.kotlin_android_learn

import com.androidyuan.kotlin_android_learn.core.CoreLogger
import com.google.gson.Gson
import com.androidyuan.kotlin_android_learn.model.UserData as UData
import org.jetbrains.anko.doAsync

/**
 * Created by wei on 17-5-19.
 * ========data class 测试类=========
 */
class DATACLSTest {


    companion object {

        val logger = CoreLogger.getLogger("DATACLSTest")
        val json= "{name:\"wei\",age:18}";

        fun test()
        {
//            val userData = UData("wei",18)
            val gson = Gson()
            val userData = gson.fromJson(json, UData::class.java)
            userData.doAsync { logger.d(userData.toString()) }

            //测试 copy
            val copyData = userData.copy(name = "wei2")
            logger.d(copyData.toString())

            //测试 映射字段到对象
            var (name:String,age:Int) = copyData
            logger.d(" field name :$name")//kotlin的String模版
            logger.d(" field age :$age")
            name = copyData.component1()
            age = copyData.component2()
            logger.d(" field name :$name")//kotlin的String模版
            logger.d(" field age :$age")

        }
    }

}