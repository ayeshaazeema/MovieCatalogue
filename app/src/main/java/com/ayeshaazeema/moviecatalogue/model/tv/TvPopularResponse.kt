package com.ayeshaazeema.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName

data class TvPopularResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: ArrayList<TvPopularItemResponse>
)
