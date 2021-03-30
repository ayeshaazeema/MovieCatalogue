package com.ayeshaazeema.moviecatalogue.adapter.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayeshaazeema.moviecatalogue.BuildConfig
import com.ayeshaazeema.moviecatalogue.R
import com.ayeshaazeema.moviecatalogue.model.movie.MovieUpcomingResponse
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_upcoming_movie.view.*

class UpcomingMovieAdapter(val listMovieUpcoming: List<MovieUpcomingResponse>) :
    RecyclerView.Adapter<UpcomingMovieAdapter.UpcomingMovieViewHolder>() {

    class UpcomingMovieViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movieUpcomingMovies: MovieUpcomingResponse) {
            with(itemView) {
                Glide.with(context).load(BuildConfig.IMAGE_URL + movieUpcomingMovies.poster_path)
                    .into(iv_poster_upcoming_movie)
                tv_title_upcoming_movie.text = movieUpcomingMovies.title
                tv_overview_upcoming_movie.text = movieUpcomingMovies.overview
                tv_date_upcoming_movie.text = movieUpcomingMovies.release_date
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UpcomingMovieViewHolder {
        return UpcomingMovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_upcoming_movie, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: UpcomingMovieViewHolder,
        position: Int
    ) {
        holder.bind(listMovieUpcoming.get(position))
    }

    override fun getItemCount(): Int = listMovieUpcoming.size
}