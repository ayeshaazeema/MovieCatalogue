package com.ayeshaazeema.moviecatalogue.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayeshaazeema.moviecatalogue.R
import com.ayeshaazeema.moviecatalogue.adapter.tv.PopularTvAdapter
import com.ayeshaazeema.moviecatalogue.adapter.tv.TopRatedTvAdapter
import com.ayeshaazeema.moviecatalogue.model.tv.TvPopularItemResponse
import com.ayeshaazeema.moviecatalogue.model.tv.TvTopRatedItemResponse
import com.ayeshaazeema.moviecatalogue.ui.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_tv.*

class TvFragment : Fragment() {

    private lateinit var tvViewModel: TvViewModel
    private lateinit var popularTvAdapter: PopularTvAdapter
    private lateinit var topRatedTvAdapter: TopRatedTvAdapter

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

        tvViewModel.initTopRatedTv(1)
        tvViewModel.getTvTopRatedData().observe(viewLifecycleOwner, Observer { tvTopRated ->
            getInitTvTopRated(tvTopRated)
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

    private fun getInitTvTopRated(tvTopRated: List<TvTopRatedItemResponse>) {
        rv_top_rated_tv.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            topRatedTvAdapter =
                TopRatedTvAdapter(
                    tvTopRated
                )
            rv_top_rated_tv.adapter = topRatedTvAdapter
        }
    }
}
