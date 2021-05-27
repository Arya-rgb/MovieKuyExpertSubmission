package com.thorin.ngemovieeuy.detail

import androidx.lifecycle.ViewModel
import com.thorin.core.domain.model.Film
import com.thorin.core.domain.usecase.FilmUseCase

class DetailMovieViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {

    fun setFavoriteMovie(film: Film, newStatus: Boolean) =
        filmUseCase.setFavoriteFilm(film, newStatus)

}