package com.thorin.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("vote_average")
    val vote_average: String,

    @field:SerializedName("vote_count")
    val vote_count: String,

    @field:SerializedName("popularity")
    val popularity: String,

    @field:SerializedName("poster_path")
    val poster_path: String,

    @field:SerializedName("backdrop_path")
    val backdrop_path: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("release_date")
    val release_date: String
)