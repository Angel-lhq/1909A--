package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        Log.i("TAG", "initView: ${max(2,3)}")
        layoutInflater.inflate(R.layout.layout_home,null)
    }
    fun max(a: Int,b: Int): Int{
        if (a>b){
            return a
        }else{
            return b
        }
    }
    val sum = {a: Int,b: Int -> a + b}
}