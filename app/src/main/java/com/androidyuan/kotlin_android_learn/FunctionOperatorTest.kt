package com.androidyuan.kotlin_android_learn

import com.androidyuan.kotlin_android_learn.core.CoreLogger
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.jetbrains.anko.collections.forEachByIndex
import kotlin.coroutines.experimental.EmptyCoroutineContext.plus

/**
 * Created by wei on 17-5-26.
 * =======函数操作符========
 */
class FunctionOperatorTest {

    companion object {
        val log = CoreLogger.getLogger("FunctionOperatorTest")
        fun main() {

            val list = listOf(1, 2, 3, 4, 5, 6)
            log.d("all % 2 =0 :" + list.all { it % 2 == 0 })
            log.d("list.count > 3 : " + list.count { it > 3 })
            log.d("list.last  > 3 : " + list.last { it > 3 })

            list.forEachIndexed { index, value ->
                log.d(" "+ index+" :" + value+"\n")
            }

            log.d("min:"+list.min())
            log.d("max:" + list.max())
            log.d("maxWith:" + list.maxWith(Comparator { o1, o2 ->  o1 - o2 }))

            log.d("fold :" + list.fold(4){
                total: Int, value: Int -> total + value
            })

            log.d("sum:"+ list.sum())
            log.d("sumby:"+ list.sumBy{ it % 2})
            //过滤操作符
            log.d("take:"+ list.take(3).toString())
            log.d("filter:"+list.filter { it> 3 }.toString())
            log.d("drop:"+list.drop(2).toString())
            log.d("dropWhile:"+list.dropLastWhile { it % 2 == 0 })
            //映射操作符



        }
    }

}