package com.thorin.core.data.source.local

import com.thorin.core.data.source.local.entity.FilmEntity
import com.thorin.core.data.source.local.room.FilmDao

import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val filmDao: FilmDao) {

    fun getAllMovie(): Flow<List<FilmEntity>> = filmDao.getAllMovie()

    fun getFavoriteMovie(): Flow<List<FilmEntity>> = filmDao.getFavoriteMovie()

    suspend fun insertMovie(movieList: List<FilmEntity>) = filmDao.insertFilm(movieList)

    fun setFavoriteFilm(film: FilmEntity, newState: Boolean) {
        film.isFavorite = newState
        filmDao.updateFavoriteFilm(film)
    }

}