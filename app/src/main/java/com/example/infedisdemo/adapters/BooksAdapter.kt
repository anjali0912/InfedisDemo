package com.example.infedisdemo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.infedisdemo.data.books.Item
import com.example.infedisdemo.data.news.Article
import com.example.infedisdemo.databinding.ItemBooksBinding
import com.example.infedisdemo.databinding.ItemNewsBinding
import com.example.infedisdemo.ui.DataViewModel

class BooksAdapter(private val viewModel: DataViewModel,
                   private val clickListener: (Item) -> Unit) :
    RecyclerView.Adapter<MyViewHolderBook>() {

    private var booksItem = listOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderBook {
        var binding = ItemBooksBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolderBook(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolderBook, position: Int) {
        holder.bind(booksItem[position], clickListener)
    }

    override fun getItemCount(): Int {
        return booksItem.size
    }

    fun setArticles(results: List<Item>) {
        booksItem = results
        notifyDataSetChanged()
    }

}

class MyViewHolderBook(val binding: ItemBooksBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item, clickListener: (Item) -> Unit) {
        binding.items = item
        binding.layoutMain.setOnClickListener {
            clickListener(item)
        }
    }
}