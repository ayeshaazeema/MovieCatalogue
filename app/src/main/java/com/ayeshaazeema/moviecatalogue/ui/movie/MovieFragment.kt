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
import com.ayeshaazeema.moviecatalogue.adapter.MovieAdapter
import com.ayeshaazeema.moviecatalogue.model.movie.ResultsItem
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieViewModel =
            ViewModelProvider(this).get(MovieViewModel::class.java)

        // Popular
        movieViewModel.init(1)
        movieViewModel.getData().observe(viewLifecycleOwner, Observer { movie ->
            getInit(movie)
        })

        // Upcoming
        movieViewModel.initUp(1)
        movieViewModel.getData().observe(viewLifecycleOwner, Observer { movieUpcoming ->
            getInitUpcoming(movieUpcoming)
        })

        val root = inflater.inflate(R.layout.fragment_movie, container, false)
        return root
    }

    private fun getInitUpcoming(movieUpcoming: List<ResultsItem>?) {

    }

    private fun getInit(movie: List<ResultsItem>?) {
        rv_popular.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            movieAdapter = movie?.let { MovieAdapter(context, listMovie = it) }!!
            rv_popular.adapter = adapter
        }
    }
}