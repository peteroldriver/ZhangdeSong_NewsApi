package com.petersong.zhangdesong_newsapi

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.petersong.zhangdesong_newsapi.databinding.ActivityNewsDetailBinding

class NewsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("123123", "jhgdkjashdf")
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val author = intent.getStringExtra("author")

        binding.title.text  = title
        binding.content.text = content
        binding.author.text = author

    }

}