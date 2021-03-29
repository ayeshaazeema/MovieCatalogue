package com.ayeshaazeema.moviecatalogue.ui.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ayeshaazeema.moviecatalogue.BuildConfig
import com.ayeshaazeema.moviecatalogue.model.tv.TvPopularItemResponse
import com.ayeshaazeema.moviecatalogue.model.tv.TvPopularResponse
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
}