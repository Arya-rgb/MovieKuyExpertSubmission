package com.thorin.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    var id: String,
    val title: String,
    val vote_average: String,
    val vote_count: String,
    val popularity: String,
    val poster_path: String,
    val backdrop_path: String,
    val overview: String,
    val release_date: String,
    var isFavorite: Boolean
) : Parcelable
