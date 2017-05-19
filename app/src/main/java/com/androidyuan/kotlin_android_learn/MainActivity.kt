package com.androidyuan.kotlin_android_learn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.androidyuan.aesjni.AESEncrypt
import com.androidyuan.kotlin_android_learn.adapter.MainAdapter

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


        forecast_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?

        forecast_list.adapter = MainAdapter(this)

    }


    override fun onClick(v: View?) {

        if(v!=null) {
            toast("加密结果: "+AESEncrypt.encode(this,"asd"))
        }
    }


    fun d(name: String) {
        CoreLogger.getLogger("MainActivityXXXX").d(name)
    }

    fun toast(title :String = "UNKNOW",length:Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,title,length).show()
    }

}
