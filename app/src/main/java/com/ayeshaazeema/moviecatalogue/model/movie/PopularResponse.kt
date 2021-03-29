package com.ayeshaazeema.moviecatalogue.model.movie

import com.google.gson.annotations.SerializedName

data class PopularResponse(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val result: ArrayList<MoviePopularItemResponse>
)



