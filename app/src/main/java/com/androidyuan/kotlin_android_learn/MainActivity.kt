package com.androidyuan.kotlin_android_learn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup

import com.androidyuan.kotlin_android_learn.core.CoreLogger
import com.androidyuan.kotlin_android_learn.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User()
        user.age = 20
        user.name = "wei"

        message.text = "被kotlin设置的TextView."

        message.setOnClickListener(this)


    }


    override fun onClick(v: View?) {

        if(v!=null) {
            d("被点击viewId:"+ v.id)
        }
    }




    fun d(name: String) {
        CoreLogger.getLogger("MainActivityXXXX").d(name)
    }

}
