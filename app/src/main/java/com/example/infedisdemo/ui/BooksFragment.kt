package com.example.infedisdemo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.infedisdemo.R
import com.example.infedisdemo.adapters.BooksAdapter
import com.example.infedisdemo.adapters.NewsAdapter
import com.example.infedisdemo.data.books.Item
import com.example.infedisdemo.data.news.Article
import com.example.infedisdemo.databinding.FragmentRecyclerviewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksFragment : Fragment() {

    /**
     * Binder to bind data with the view.
     */
    private lateinit var binding: FragmentRecyclerviewBinding

    /**
     * Converts the simple data into view and set to the recycler view.
     */
    private lateinit var adapter: BooksAdapter

    /**
     * DataViewModel injected by dependency injection.
     */
    private val viewModel by viewModel<DataViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerviewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observerBooks()
    }

    /**
     * Initialize the view.
     */
    private fun initView() {
        adapter = BooksAdapter(viewModel, {selectedItem: Item ->
            listItemClicked(selectedItem)})
        binding.recyclerView.adapter = adapter
    }

    /**
     * Observes the books data and set to the recycler view.
     */
    private fun observerBooks() {
        viewModel.resultBooks.observe(viewLifecycleOwner, Observer<List<Item>> {
            if (!it.isNullOrEmpty()) {
                adapter.setArticles(it)
                for(item in it){
                    Log.d(">>>>",item.volumeInfo.imageLinks?.smallThumbnail.toString())
                }
            }
        })
    }

    private  fun listItemClicked(item: Item){
        Toast.makeText(context,"clicked-"+item.kind, Toast.LENGTH_SHORT).show()
    }
}