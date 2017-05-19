package com.androidyuan.kotlin_android_learn.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.androidyuan.kotlin_android_learn.R
import org.w3c.dom.Text

/**
 * Created by wei on 17-5-19.
 * =============kotlin adapter=====================
 */
class MainAdapter(con:Context) : RecyclerView.Adapter<MainAdapter.MainVH>() {

    val context: Context= con


    override fun getItemCount(): Int {
        return 120
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainVH {
        val view : View= LayoutInflater.from(context).inflate(R.layout.item_mainlist,null)
        val vh : MainVH= MainVH(view)
        return vh
    }

    override fun onBindViewHolder(holder: MainVH?, position: Int) {

        val txt = holder!!.title
        txt.text = "test xx"
    }


    class MainVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView!!.findViewById(R.id.title) as TextView
    }
}