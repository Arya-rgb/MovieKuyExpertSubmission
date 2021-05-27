package com.thorin.core.domain.usecase

import com.thorin.core.data.Resource
import com.thorin.core.domain.model.Film
import kotlinx.coroutines.flow.Flow

interface FilmUseCase {

    fun getAllMovieNowPlaying(): Flow<Resource<List<Film>>>

    fun setFavoriteFilm(film: Film, state: Boolean)

    fun getFavoriteMovie(): Flow<List<Film>>

}