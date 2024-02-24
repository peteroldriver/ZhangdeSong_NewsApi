package com.petersong.zhangdesong_newsapi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.petersong.zhangdesong_newsapi.Model.Article
import com.petersong.zhangdesong_newsapi.Model.News
import com.petersong.zhangdesong_newsapi.Network.NewsDataHandler
import com.petersong.zhangdesong_newsapi.databinding.FragmentBusinessNewsBinding
import com.petersong.zhangdesong_newsapi.databinding.FragmentSportsNewsBinding
import com.petersong.zhangdesong_newsapi.ui.home.NewsListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BusinessNewsFragment : Fragment() {
    val TAG="Business Fragment KT"
        private var _binding: FragmentBusinessNewsBinding? = null
        private val binding
            get() = checkNotNull(_binding) {
                "Cannot access binding because it is null. Is the view visible?"
            }

        lateinit var articleList : List<Article>
        lateinit var adapter: NewsListAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            Log.e(com.petersong.zhangdesong_newsapi.ui.home.TAG, "onCreate()")
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentBusinessNewsBinding.inflate(inflater, container, false)
            var newsDataHandler = NewsDataHandler()
            binding.rvBusinessNews.layoutManager = LinearLayoutManager(context)
            newsDataHandler.retrofit.getBusinessNews().enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    Log.e(TAG, "Success:")
                    //val jokes: DataModel = response.body() as DataModel
                    if (response.isSuccessful) {
                        val news : News = response.body() as News
                        articleList = news.articles
                        adapter = NewsListAdapter(articleList)
                        binding.rvBusinessNews.adapter = adapter
                        Log.e(com.petersong.zhangdesong_newsapi.ui.home.TAG, "Success2:")
                    }
                }
                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.e(com.petersong.zhangdesong_newsapi.ui.home.TAG, "onFailure: ${t.message}")
                }
            })

            binding.btnSport.setOnClickListener {
                Navigation.findNavController(
                    binding.root
                ).navigate(R.id.action_businessNewsFragment_to_sportsNewsFragment)
            }

            binding.btnTopGeneral.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.action_businessNewsFragment_to_itemFragment)
            }

            return binding.root
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.e(com.petersong.zhangdesong_newsapi.ui.home.TAG, "ondesctroy:")
            _binding = null
        }
    }