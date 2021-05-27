package com.thorin.core.domain.repository

import com.thorin.core.data.Resource
import com.thorin.core.domain.model.Film

import kotlinx.coroutines.flow.Flow

interface IFilmRepository {

    fun getAllMovieNowPlaying() : Flow<Resource<List<Film>>>

    fun setFavoriteFilm(film: Film, state: Boolean)

    fun getFavoriteMovie(): Flow<List<Film>>

}