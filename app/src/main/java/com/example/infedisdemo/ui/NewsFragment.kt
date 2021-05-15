package com.example.infedisdemo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.infedisdemo.adapters.NewsAdapter
import com.example.infedisdemo.data.news.Article
import com.example.infedisdemo.databinding.FragmentRecyclerviewBinding
import com.example.infedisdemo.util.NewsEnum
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment(private val newsEnum: NewsEnum) : Fragment() {

    /**
     * Binder to bind data with the view.
     */
    private lateinit var binding: FragmentRecyclerviewBinding

    /**
     * Converts the simple data into view and set to the recycler view.
     */
    private lateinit var adapter: NewsAdapter

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
        setAdapterByNewsType(newsEnum)
    }

    private fun setAdapterByNewsType(newsEnum: NewsEnum) {
        when (newsEnum) {
            NewsEnum.BITCOIN -> observerBitcoin()
            NewsEnum.BUSINESS -> observerBuiness()
            NewsEnum.APPLE -> observerApple()
            NewsEnum.TECHCRUNCH -> observerTechCrunch()
            NewsEnum.WALL_STREET -> observerWallStreet()
        }
    }

    /**
     * Initialize the view.
     */
    private fun initView() {
        adapter = NewsAdapter(viewModel, {selectedItem: Article ->
            listItemClicked(selectedItem)})
        binding.recyclerView.adapter = adapter
    }

    /**
     * Observes the bitcoin news data and set to the recycler view.
     */
    private fun observerBitcoin() {
        viewModel.resultBitcoinNews.observe(viewLifecycleOwner, Observer<List<Article>> {
            if (!it.isNullOrEmpty()) {
                adapter.setArticles(it)
            }
        })
    }

    /**
     * Observes the business news data and set to the recycler view.
     */
    private fun observerBuiness() {
        viewModel.resultBusinessNews.observe(viewLifecycleOwner, Observer<List<Article>> {
            if (!it.isNullOrEmpty()) {
                adapter.setArticles(it)
            }
        })
    }

    /**
     * Observes the apple news data and set to the recycler view.
     */
    private fun observerApple() {
        viewModel.resultAppleNews.observe(viewLifecycleOwner, Observer<List<Article>> {
            if (!it.isNullOrEmpty()) {
                adapter.setArticles(it)
            }
        })
    }

    /**
     * Observes the tech crunch news data and set to the recycler view.
     */
    private fun observerTechCrunch() {
        viewModel.resultTechCrunchNews.observe(viewLifecycleOwner, Observer<List<Article>> {
            if (!it.isNullOrEmpty()) {
                adapter.setArticles(it)
            }
        })
    }

    /**
     * Observes the wall street news data and set to the recycler view.
     */
    private fun observerWallStreet() {
        viewModel.resultWallStreetNews.observe(viewLifecycleOwner, Observer<List<Article>> {
            if (!it.isNullOrEmpty()) {
                adapter.setArticles(it)
            }
        })
    }

    private  fun listItemClicked(article: Article){
        Toast.makeText(context,"clicked-"+article.title, Toast.LENGTH_SHORT).show()
    }
}