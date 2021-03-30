package com.ayeshaazeema.moviecatalogue.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayeshaazeema.moviecatalogue.BuildConfig
import com.ayeshaazeema.moviecatalogue.model.movie.*
import com.ayeshaazeema.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    fun init(page: Int) {
        getPopularMovie(page)
    }

    // Data
    private val data = MutableLiveData<List<MoviePopularItemResponse>>()

    private fun getPopularMovie(page: Int) {
        RetrofitConfig().getApiService().getPopular(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<MoviePopularResponse> {

                override fun onResponse(
                    call: Call<MoviePopularResponse>,
                    responseMovie: Response<MoviePopularResponse>
                ) {
                    if (responseMovie.isSuccessful) {
                        val responseMovieMovie: MoviePopularResponse? = responseMovie.body()
                        data.postValue(responseMovieMovie?.result)
                    }
                }

                override fun onFailure(call: Call<MoviePopularResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }

    // Get all attribute for popular movie
    fun getData(): LiveData<List<MoviePopularItemResponse>> {
        return data
    }

    /*========== Upcoming Movie ==========*/

    // Call page
    fun initUp(page: Int) {
        getUpcoming(page)
    }

    private val dataUpcoming = MutableLiveData<List<MovieUpcomingResponse>>()

    private fun getUpcoming(page: Int) {
        RetrofitConfig().getApiService().getUpcoming(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<MovieUpcomingItemResponse> {

                override fun onResponse(
                    call: Call<MovieUpcomingItemResponse>,
                    response: Response<MovieUpcomingItemResponse>
                ) {
                    if (response.isSuccessful) {
                        val upcomingResponse: MovieUpcomingItemResponse? = response.body()
                        dataUpcoming.postValue(upcomingResponse?.result)
                    }
                }

                override fun onFailure(call: Call<MovieUpcomingItemResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }

    fun getDataUpcoming(): LiveData<List<MovieUpcomingResponse>> {
        return dataUpcoming
    }
}