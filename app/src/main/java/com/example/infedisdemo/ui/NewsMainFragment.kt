package com.example.infedisdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.infedisdemo.adapters.TabAdapter
import com.example.infedisdemo.databinding.ActivityMainBinding
import com.example.infedisdemo.util.NewsEnum

class NewsMainFragment : Fragment() {

    /**
     * Hold instance of tab adapter.
     */
    private lateinit var tabAdapter: TabAdapter

    /**
     * Binder to bind data with the view.
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        tabAdapter.addFragment(NewsFragment(NewsEnum.BITCOIN), "Bitcoin")
        tabAdapter.addFragment(NewsFragment(NewsEnum.BUSINESS), "Business")
        tabAdapter.addFragment(NewsFragment(NewsEnum.APPLE), "Apple")
        tabAdapter.addFragment(NewsFragment(NewsEnum.TECHCRUNCH), "TechCrunch")
        tabAdapter.addFragment(NewsFragment(NewsEnum.WALL_STREET), "Wall Street")
        binding.viewpager.adapter = tabAdapter
        binding.tabs.setupWithViewPager(binding.viewpager)
    }

    private fun initView() {
        tabAdapter = TabAdapter(childFragmentManager)
    }
}