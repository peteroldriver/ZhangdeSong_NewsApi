package com.petersong.zhangdesong_newsapi.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.petersong.zhangdesong_newsapi.Model.Article
import com.petersong.zhangdesong_newsapi.Model.News
import com.petersong.zhangdesong_newsapi.Network.NewsDataHandler
import com.petersong.zhangdesong_newsapi.R
import com.petersong.zhangdesong_newsapi.databinding.TopNewsListFragmentBinding
import com.petersong.zhangdesong_newsapi.placeholder.PlaceholderContent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 */
val TAG = "ItemFragment.kt TAG"
class ItemFragment : Fragment() {
    private var _binding: TopNewsListFragmentBinding? = null
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
    ): View? {
        _binding = TopNewsListFragmentBinding.inflate(inflater, container, false)
        var newsDataHandler = NewsDataHandler()
       binding.rvTopNews.layoutManager = LinearLayoutManager(context)
        newsDataHandler.retrofit.getTopHeadlines().enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.e(TAG, "Success:")
                //val jokes: DataModel = response.body() as DataModel
                if (response.isSuccessful) {
                    val news : News = response.body() as News
                    articleList = news.articles
                    adapter = NewsListAdapter(articleList)
                    binding.rvTopNews.adapter = adapter
                    Log.e(TAG, "Success2:")
                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
        binding.btnBusiness.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_itemFragment_to_businessNewsFragment)
        }

        binding.btnSport.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_itemFragment_to_sportsNewsFragment)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "ondesctroy:")
        _binding = null
    }
}