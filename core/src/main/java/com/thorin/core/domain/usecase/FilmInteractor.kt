package com.thorin.core.domain.usecase


import com.thorin.core.domain.model.Film
import com.thorin.core.domain.repository.IFilmRepository


class FilmInteractor(private val filmRepository: IFilmRepository) : FilmUseCase {

    override fun getAllMovieNowPlaying() = filmRepository.getAllMovieNowPlaying()

    override fun setFavoriteFilm(film: Film, state: Boolean) = filmRepository.setFavoriteFilm(film, state)

    override fun getFavoriteMovie() = filmRepository.getFavoriteMovie()


}