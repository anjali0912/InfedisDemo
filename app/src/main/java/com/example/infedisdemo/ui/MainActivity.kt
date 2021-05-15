package com.example.infedisdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.infedisdemo.R
import com.example.infedisdemo.adapters.TabAdapter
import com.example.infedisdemo.databinding.ActivityMainBinding
import com.example.infedisdemo.util.NewsEnum

class MainActivity : AppCompatActivity() {

    /**
     * Hold instance of tab adapter.
     */
    private lateinit var tabAdapter: TabAdapter

    /**
     * Binder to bind data with the view.
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        );

        initView()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        tabAdapter.addFragment(NewsMainFragment(), "News")
        tabAdapter.addFragment(BooksFragment(), "Books")
        binding.viewpager.adapter = tabAdapter
        binding.tabs.setupWithViewPager(binding.viewpager)
    }

    private fun initView() {
        tabAdapter = TabAdapter(supportFragmentManager)
    }
}