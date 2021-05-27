package com.thorin.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_film")
data class FilmEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name ="title")
    val title: String,

    @ColumnInfo(name ="vote_average")
    val vote_average: String,

    @ColumnInfo(name ="vote_count")
    val vote_count: String,

    @ColumnInfo(name ="popularity")
    val popularity: String,

    @ColumnInfo(name ="poster_path")
    val poster_path: String,

    @ColumnInfo(name ="backdrop_path")
    val backdrop_path: String,

    @ColumnInfo(name ="overview")
    val overview: String,

    @ColumnInfo(name ="release_date")
    val release_date: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean

)