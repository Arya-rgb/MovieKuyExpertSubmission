package com.thorin.core.utils

import com.thorin.core.data.source.local.entity.FilmEntity
import com.thorin.core.data.source.remote.response.DataResponse
import com.thorin.core.domain.model.Film


object DataMapper {
    fun mapResponsesToEntities(input: List<DataResponse>): List<FilmEntity> {
        val filmList = ArrayList<FilmEntity>()
        input.map {
            val film = FilmEntity(
                id = it.id,
                title = it.title,
                vote_average = it.vote_average,
                vote_count = it.vote_count,
                popularity = it.popularity,
                poster_path = it.poster_path,
                backdrop_path = it.backdrop_path,
                overview = it.overview,
                release_date = it.release_date,
                isFavorite = false
            )
            filmList.add(film)
        }
        return filmList
    }

    fun mapEntitiesToDomain(input: List<FilmEntity>): List<Film> =
        input.map {
            Film(
                id = it.id,
                title = it.title,
                vote_average = it.vote_average,
                vote_count = it.vote_count,
                popularity = it.popularity,
                poster_path = it.poster_path,
                backdrop_path = it.backdrop_path,
                overview = it.overview,
                release_date = it.release_date,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Film) = FilmEntity(
        id = input.id,
        title = input.title,
        vote_average = input.vote_average,
        vote_count = input.vote_count,
        popularity = input.popularity,
        poster_path = input.poster_path,
        backdrop_path = input.backdrop_path,
        overview = input.overview,
        release_date = input.release_date,
        isFavorite = input.isFavorite
    )
}