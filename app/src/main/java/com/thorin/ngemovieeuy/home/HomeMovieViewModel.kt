package com.thorin.ngemovieeuy.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.thorin.core.domain.usecase.FilmUseCase


class HomeMovieViewModel(filmUseCase: FilmUseCase) : ViewModel() {

    val film = filmUseCase.getAllMovieNowPlaying().asLiveData()

}