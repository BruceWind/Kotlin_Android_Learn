package com.androidyuan.kotlin_android_learn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.androidyuan.aesjni.AESEncrypt
import com.androidyuan.kotlin_android_learn.adapter.MainAdapter
import com.androidyuan.kotlin_android_learn.adapter.MainAdapterClickListener

import com.androidyuan.kotlin_android_learn.core.CoreLogger
import com.androidyuan.kotlin_android_learn.model.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.async
import java.lang.Exception
import java.net.URL
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user: User = User("wei", 18)
        d(user.name)
//        user.age = 20
//        user.name = "wei"

        message.text = "被kotlin设置的TextView."

        message.setOnClickListener(this)
        AESEncrypt.checkSignature(this)


        forecast_list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager
        forecast_list.adapter = MainAdapter(this,object :MainAdapterClickListener{
            override fun invoke(index: Int) {
                toast("click:"+index)
            }

        })


        async(Executors.newSingleThreadExecutor()) {//线程
            val forecastJsonStr = URL("http://www.runoob.com/index.html?language=cn#j2se").readText()

            CoreLogger.getLogger("MainActivityXXXX").d(forecastJsonStr)

            uiThread { toast("请求成功。") }

        }


        KotlinFPMain.main()
        FunctionOperatorTest.main()
        DATACLSTest.test()

    }


    override fun onClick(v: View?) {

        if (v != null) {
            //use anko
            toast("加密结果: " + AESEncrypt.encode(this, "asd"))
            //longToast("加密结果: "+AESEncrypt.encode(this,"asd"))// anko
        }
    }


    fun d(name: String) {
        CoreLogger.getLogger("MainActivityXXXX").d(name)
    }


}
