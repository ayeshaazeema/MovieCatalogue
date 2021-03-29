package com.ayeshaazeema.moviecatalogue.network

import com.ayeshaazeema.moviecatalogue.model.movie.MovieUpcomingItemResponse
import com.ayeshaazeema.moviecatalogue.model.movie.PopularResponse
import com.ayeshaazeema.moviecatalogue.model.tv.TvPopularResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<PopularResponse>

    @GET("movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<MovieUpcomingItemResponse>

    @GET("tv/popular")
    fun getTvPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<TvPopularResponse>
}