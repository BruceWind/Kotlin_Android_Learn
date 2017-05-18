package com.androidyuan.kotlin_android_learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidyuan.kotlin_android_learn.core.CoreLogger;
import com.androidyuan.kotlin_android_learn.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user=new User();
        user.setAge(20);
        user.setName("wei");


        CoreLogger.Companion.getLogger("MainActivityXXXX").d(user.getName());


    }
}
