package com.petersong.zhangdesong_newsapi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.petersong.zhangdesong_newsapi.Model.Article
import com.petersong.zhangdesong_newsapi.Model.News
import com.petersong.zhangdesong_newsapi.Network.NewsDataHandler
import com.petersong.zhangdesong_newsapi.databinding.ActivityMainBinding
import com.petersong.zhangdesong_newsapi.ui.home.NewsListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity.kt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = applicationContext

        }
    companion object{
        lateinit var context: Context
        fun getApplicationContext():Context{
            return context
        }


    }


    }