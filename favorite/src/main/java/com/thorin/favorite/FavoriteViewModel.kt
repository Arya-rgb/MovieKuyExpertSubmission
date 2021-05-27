package com.thorin.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.thorin.core.domain.usecase.FilmUseCase

class FavoriteViewModel(filmUseCase: FilmUseCase) : ViewModel() {

    val favoriteMovie = filmUseCase.getFavoriteMovie().asLiveData()

}