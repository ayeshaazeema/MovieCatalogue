package com.ayeshaazeema.moviecatalogue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayeshaazeema.moviecatalogue.BuildConfig
import com.ayeshaazeema.moviecatalogue.R
import com.ayeshaazeema.moviecatalogue.model.movie.ResultsItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(var context: Context, var listMovie: List<ResultsItem>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: ResultsItem) {
            with(itemView)
            {
                Glide.with(context).load(BuildConfig.IMAGE_URL + movie.posterPath)
                    .into(iv_movie_poster)
                tv_movie_title.text = movie.title
                itemView.setOnClickListener{}
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie.get(position))
    }

    override fun getItemCount(): Int = listMovie.size
}