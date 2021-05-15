package com.example.infedisdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.infedisdemo.data.news.Article
import com.example.infedisdemo.data.repository.DataRepository
import com.example.infedisdemo.databinding.ItemNewsBinding
import com.example.infedisdemo.ui.DataViewModel

class NewsAdapter(private val viewModel: DataViewModel,
                  private val clickListener: (Article) -> Unit) :
    RecyclerView.Adapter<MyViewHolder>() {

    private var article = listOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(article[position], clickListener)
    }

    override fun getItemCount(): Int {
        return article.size
    }

    fun setArticles(results: List<Article>) {
        article = results
        notifyDataSetChanged()
    }

}

class MyViewHolder(val binding: ItemNewsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Article, clickListener: (Article) -> Unit) {
        binding.articles = item
        binding.layoutMain.setOnClickListener {
            clickListener(item)
        }
    }
}