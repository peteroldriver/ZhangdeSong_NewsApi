package com.petersong.zhangdesong_newsapi.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petersong.zhangdesong_newsapi.Model.Article
import com.petersong.zhangdesong_newsapi.databinding.NewsItemBinding

import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.petersong.zhangdesong_newsapi.MainActivity
import com.petersong.zhangdesong_newsapi.NewsDetailActivity


class LayoutNewsHolder(
    private val binding: NewsItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    val TAG = "NewsAdapter.kt"
    fun bind(article: Article) {
        binding.newsTitle.text = article.title
        binding.newsAuthor.text = article.author
        binding.root.setOnClickListener{
            val intent = Intent(MainActivity.getApplicationContext(), NewsDetailActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("title", article.title)
            intent.putExtra("author", article.author)
            intent.putExtra("content", article.content)
            MainActivity.getApplicationContext().startActivity(intent)
        }
        }
    }

class NewsListAdapter(
    private val article: List<Article>
) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "viewType: $viewType")
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(inflater, parent, false)
        return LayoutNewsHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crime = article[position]
        (holder as LayoutNewsHolder).bind(crime)

    }

    override fun getItemCount() = article.size

}