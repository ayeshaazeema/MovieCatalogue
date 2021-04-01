package com.ayeshaazeema.moviecatalogue.ui.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayeshaazeema.moviecatalogue.BuildConfig
import com.ayeshaazeema.moviecatalogue.model.tv.TvPopularItemResponse
import com.ayeshaazeema.moviecatalogue.model.tv.TvPopularResponse
import com.ayeshaazeema.moviecatalogue.model.tv.TvTopRatedItemResponse
import com.ayeshaazeema.moviecatalogue.model.tv.TvTopRatedResponse
import com.ayeshaazeema.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvViewModel : ViewModel() {

    fun initPopularTv(page: Int) {
        getPopularTv(page)
    }

    private val dataPopularTv = MutableLiveData<List<TvPopularItemResponse>>()

    private fun getPopularTv(page: Int) {
        RetrofitConfig().getApiService().getTvPopular(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<TvPopularResponse> {

                override fun onResponse(
                    call: Call<TvPopularResponse>,
                    response: Response<TvPopularResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseTvPopular: TvPopularResponse? = response.body()
                        dataPopularTv.postValue(responseTvPopular?.results)
                    }
                }

                override fun onFailure(call: Call<TvPopularResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }

    fun getTvPopularData(): LiveData<List<TvPopularItemResponse>> {
        return dataPopularTv
    }

     // Top Rated TV

    fun initTopRatedTv(page: Int) {
        getTopRatedTv(page)
    }

    private val dataTopRatedTv = MutableLiveData<List<TvTopRatedItemResponse>>()

    private fun getTopRatedTv(page: Int) {
        RetrofitConfig().getApiService().getTvTopRated(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<TvTopRatedResponse> {

                override fun onResponse(
                    call: Call<TvTopRatedResponse>,
                    response: Response<TvTopRatedResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseTvTopRated: TvTopRatedResponse? = response.body()
                        dataTopRatedTv.postValue(responseTvTopRated?.results)
                    }
                }

                override fun onFailure(call: Call<TvTopRatedResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }

    fun getTvTopRatedData(): LiveData<List<TvTopRatedItemResponse>> {
        return dataTopRatedTv
    }
}


