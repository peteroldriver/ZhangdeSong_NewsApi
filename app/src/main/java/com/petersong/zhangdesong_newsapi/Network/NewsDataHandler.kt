package com.petersong.zhangdesong_newsapi.Network

import android.util.Log
import com.petersong.zhangdesong_newsapi.MainActivity
import com.petersong.zhangdesong_newsapi.Model.News
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// https://www.pushing-pixels.org/2019/12/04/working-with-retrofit-and-moshi-in-kotlin.html
class NewsDataHandler(
    private val API_KEY: String = ""
) {

    private val BASE_URL = "https://newsapi.org/v2/"

    //Log Responses from API to LogCat
    private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var TAG = "NewsDataHandler.kt"
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val retrofit: ApiInterface = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(ApiInterface::class.java)



}
