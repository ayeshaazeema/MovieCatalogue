package com.ayeshaazeema.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName

data class TvTopRatedItemResponse (
    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("name")
    val name: String
)