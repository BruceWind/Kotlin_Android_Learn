package com.androidyuan.aesjni

/**
 * Created by wei on 16-12-2.
 * 用于测试 kotlin 调用 c语言
 */

object AESEncrypt {

    init {
        System.loadLibrary("JNIEncrypt")
    }

    /**
     * AES加密

     * @param context
     * *
     * @param str
     * *
     * @return
     */
    external fun encode(context: Any, str: String): String


    /**
     * AES 解密

     * @param context
     * *
     * @param str
     * *
     * @return UNSIGNATURE ： sign not pass .
     */
    external fun decode(context: Any, str: String): String


    /**
     * 检查 打包签名是否 是正确的 防止被二次打包

     * @param con
     * *
     * @return 1 : pass ， -1 or  -2 : error.
     */
    external fun checkSignature(context: Any): Int
}
