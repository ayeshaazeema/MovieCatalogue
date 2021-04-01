package com.ayeshaazeema.moviecatalogue.network

import com.ayeshaazeema.moviecatalogue.model.movie.MovieUpcomingItemResponse
import com.ayeshaazeema.moviecatalogue.model.movie.MoviePopularResponse
import com.ayeshaazeema.moviecatalogue.model.tv.TvPopularResponse
import com.ayeshaazeema.moviecatalogue.model.tv.TvTopRatedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<MoviePopularResponse>

    @GET("movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<MovieUpcomingItemResponse>

    @GET("tv/top_rated")
    fun getTvTopRated(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<TvTopRatedResponse>

    @GET("tv/popular")
    fun getTvPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<TvPopularResponse>
}