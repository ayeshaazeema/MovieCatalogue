package com.ayeshaazeema.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayeshaazeema.moviecatalogue.BuildConfig
import com.ayeshaazeema.moviecatalogue.R
import com.ayeshaazeema.moviecatalogue.model.movie.MoviePopularItemResponse
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class PopularMovieAdapter(var listMoviePopular: List<MoviePopularItemResponse>) :
    RecyclerView.Adapter<PopularMovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(moviePopular: MoviePopularItemResponse) {
            with(itemView)
            {
                Glide.with(context).load(BuildConfig.IMAGE_URL + moviePopular.poster_path)
                    .into(iv_movie_poster)
                tv_movie_title.text = moviePopular.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMoviePopular.get(position))
    }

    override fun getItemCount(): Int = listMoviePopular.size
}