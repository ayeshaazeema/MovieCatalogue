package com.ayeshaazeema.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayeshaazeema.moviecatalogue.BuildConfig
import com.ayeshaazeema.moviecatalogue.R
import com.ayeshaazeema.moviecatalogue.model.tv.TvPopularItemResponse
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_popular_tv.view.*

class PopularTvAdapter(val listTvPopular: List<TvPopularItemResponse>) :
    RecyclerView.Adapter<PopularTvAdapter.TvPopularViewHolder>() {

    class TvPopularViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(tvpopular: TvPopularItemResponse) {
            with(itemView) {
                Glide.with(context).load(BuildConfig.IMAGE_URL + tvpopular.poster_path)
                    .into(iv_poster_popular_tv)
                tv_title_popular_tv.text = tvpopular.name
                tv_overview_popular_tv.text = tvpopular.overview
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularTvAdapter.TvPopularViewHolder {
        return TvPopularViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_popular_tv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PopularTvAdapter.TvPopularViewHolder, position: Int) {
        holder.bind(listTvPopular.get(position))
    }

    override fun getItemCount(): Int = listTvPopular.size
}