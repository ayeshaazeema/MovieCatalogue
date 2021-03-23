package com.ayeshaazeema.moviecatalogue.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayeshaazeema.moviecatalogue.BuildConfig
import com.ayeshaazeema.moviecatalogue.model.movie.PopularResponse
import com.ayeshaazeema.moviecatalogue.model.movie.ResultsItem
import com.ayeshaazeema.moviecatalogue.model.movie.UpcomingResponse
import com.ayeshaazeema.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    fun init(page: Int) {
        getPopularMovie(page)
    }

    // Data
    private val data = MutableLiveData<List<ResultsItem>>()

    private fun getPopularMovie(page: Int) {
        RetrofitConfig().getApiService().getPopular(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<PopularResponse> {

                override fun onResponse(
                    call: Call<PopularResponse>,
                    response: Response<PopularResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseMovie: PopularResponse? = response.body()
                        data.postValue(responseMovie?.results!! as List<ResultsItem>?)
                    }
                }

                override fun onFailure(call: Call<PopularResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }

    // Get all attribute
    fun getData(): LiveData<List<ResultsItem>> {
        return data
    }

    // Call page
    fun initUp(page: Int) {
        getUpcoming(page)
    }

    private fun getUpcoming(page: Int) {
        RetrofitConfig().getApiService().getUpcoming(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<UpcomingResponse> {

                override fun onResponse(
                    call: Call<UpcomingResponse>,
                    response: Response<UpcomingResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseUpcoming: UpcomingResponse? = response.body()
                        data.postValue(responseUpcoming?.results as List<ResultsItem>?)
                    }
                }

                override fun onFailure(call: Call<UpcomingResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }
}