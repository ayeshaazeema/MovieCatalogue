package com.ayeshaazeema.moviecatalogue.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayeshaazeema.moviecatalogue.R
import com.ayeshaazeema.moviecatalogue.adapter.tv.PopularTvAdapter
import com.ayeshaazeema.moviecatalogue.model.tv.TvPopularItemResponse
import kotlinx.android.synthetic.main.fragment_tv.*

class TvFragment : Fragment() {

    private lateinit var tvViewModel: TvViewModel
    private lateinit var popularTvAdapter: PopularTvAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_tv, container, false)
        tvViewModel = ViewModelProvider(this).get(TvViewModel::class.java)
        tvViewModel.initPopularTv(1)

        tvViewModel.getTvPopularData().observe(viewLifecycleOwner, { tvPopular ->
            getInitTvPopular(tvPopular)
        })
        return root
    }

    private fun getInitTvPopular(tvPopular: List<TvPopularItemResponse>) {
        rv_popular_tv.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            popularTvAdapter =
                PopularTvAdapter(
                    tvPopular
                )
            rv_popular_tv.adapter = popularTvAdapter
        }

    }
}