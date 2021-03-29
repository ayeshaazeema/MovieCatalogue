package com.ayeshaazeema.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayeshaazeema.moviecatalogue.R
import com.ayeshaazeema.moviecatalogue.adapter.PopularMovieAdapter
import com.ayeshaazeema.moviecatalogue.adapter.UpcomingMovieAdapter
import com.ayeshaazeema.moviecatalogue.model.movie.MoviePopularItemResponse
import com.ayeshaazeema.moviecatalogue.model.movie.UpcomingResponse
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var popularMovieAdapter: PopularMovieAdapter
    private lateinit var upcomingMovieAdapter: UpcomingMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movie, container, false)

        movieViewModel =
            ViewModelProvider(this).get(MovieViewModel::class.java)

        // Popular
        movieViewModel.init(1)
        movieViewModel.getData().observe(viewLifecycleOwner, Observer { popularMovie ->
            getInitPopular(popularMovie)
        })

        // Upcoming
        movieViewModel.initUp(1)
        movieViewModel.getDataUpcoming().observe(viewLifecycleOwner, Observer { movieUpcoming ->
            getInitUpcoming(movieUpcoming)
        })

        return root
    }

    private fun getInitUpcoming(movieUpcoming: List<UpcomingResponse>) {
        rv_upcoming.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            upcomingMovieAdapter = UpcomingMovieAdapter(movieUpcoming)
            rv_upcoming.adapter = upcomingMovieAdapter
        }
    }

    private fun getInitPopular(popularMoviePopular: List<MoviePopularItemResponse>) {
        // Asyncronus
        rv_popular.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            popularMovieAdapter = PopularMovieAdapter(popularMoviePopular)
            rv_popular.adapter = popularMovieAdapter
        }
    }
}