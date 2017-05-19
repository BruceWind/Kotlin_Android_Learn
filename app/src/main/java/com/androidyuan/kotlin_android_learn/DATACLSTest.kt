package com.androidyuan.kotlin_android_learn

import com.androidyuan.kotlin_android_learn.core.CoreLogger
import com.androidyuan.kotlin_android_learn.model.UserData
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult

/**
 * Created by wei on 17-5-19.
 * ========data class 测试类=========
 */
class DATACLSTest {


    companion object {

        val logger = CoreLogger.getLogger("DATACLSTest")

        fun test()
        {
            val userData = UserData("wei",18)
            userData.doAsync { logger.d(userData.toString()) }

            //测试 copy
            val copyData = userData.copy(name = "wei2")
            logger.d(copyData.toString())

            //测试 取出字段
            val (name:String,age:Int) = copyData
            logger.d(" field name = "+name)
            logger.d(" field age = "+age)

        }
    }

}