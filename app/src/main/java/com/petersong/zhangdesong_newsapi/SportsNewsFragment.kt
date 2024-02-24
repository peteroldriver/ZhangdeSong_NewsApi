package com.petersong.zhangdesong_newsapi

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
import com.petersong.zhangdesong_newsapi.databinding.FragmentSportsNewsBinding
import com.petersong.zhangdesong_newsapi.databinding.TopNewsListFragmentBinding
import com.petersong.zhangdesong_newsapi.ui.home.NewsListAdapter
import com.petersong.zhangdesong_newsapi.ui.home.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val TAG = ""
class SportsNewsFragment : Fragment() {
        private var _binding: FragmentSportsNewsBinding? = null
        private val binding
            get() = checkNotNull(_binding) {
                "Cannot access binding because it is null. Is the view visible?"
            }

        lateinit var articleList : List<Article>
        lateinit var adapter: NewsListAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            Log.e(TAG, "onCreate()")
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentSportsNewsBinding.inflate(inflater, container, false)
            var newsDataHandler = NewsDataHandler()
            binding.rvSportsNews.layoutManager = LinearLayoutManager(context)
            newsDataHandler.retrofit.getSportsNews().enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    Log.e(TAG, "Success:")
                    //val jokes: DataModel = response.body() as DataModel
                    if (response.isSuccessful) {
                        val news : News = response.body() as News
                        articleList = news.articles
                        adapter = NewsListAdapter(articleList)
                        binding.rvSportsNews.adapter = adapter
                        Log.e(TAG, "Success2:")
                    }
                }
                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
            binding.btnBusiness.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.action_sportsNewsFragment_to_businessNewsFragment)
            }

            binding.btnTopGeneral.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.action_sportsNewsFragment_to_itemFragment)
            }
            return binding.root
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.e(TAG, "ondesctroy:")
            _binding = null
        }
    }