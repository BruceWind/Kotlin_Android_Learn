package com.androidyuan.kotlin_android_learn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.androidyuan.aesjni.AESEncrypt

import com.androidyuan.kotlin_android_learn.core.CoreLogger
import com.androidyuan.kotlin_android_learn.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user:User = User("wei",18)
        d(user.name)
//        user.age = 20
//        user.name = "wei"

        message.text = "被kotlin设置的TextView."

        message.setOnClickListener(this)
        AESEncrypt.checkSignature(this)

    }


    override fun onClick(v: View?) {

        if(v!=null) {
            d("加密结果: "+AESEncrypt.encode(this,"asd"))
        }
    }


    fun d(name: String) {
        CoreLogger.getLogger("MainActivityXXXX").d(name)
    }

}
