package com.petersong.zhangdesong_newsapi.Network

import com.petersong.zhangdesong_newsapi.Model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines?country=us&apiKey=e567bf85a2b94579b445aeda638bdeb5")
    fun getTopHeadlines(): Call<News>

    @GET("top-headlines?country=us&category=sports&apiKey=e567bf85a2b94579b445aeda638bdeb5")
    fun getSportsNews(): Call<News>

    @GET("top-headlines?country=us&category=business&apiKey=e567bf85a2b94579b445aeda638bdeb5")
    fun getBusinessNews(): Call<News>
}