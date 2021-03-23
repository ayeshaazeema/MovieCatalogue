package com.ayeshaazeema.moviecatalogue.network

import com.ayeshaazeema.moviecatalogue.model.movie.PopularResponse
import com.ayeshaazeema.moviecatalogue.model.movie.UpcomingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<PopularResponse>

    @GET("/movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): retrofit2.Call<UpcomingResponse>
}