package com.thorin.ngemovieeuy.di

import com.thorin.core.domain.usecase.FilmInteractor
import com.thorin.core.domain.usecase.FilmUseCase
import com.thorin.ngemovieeuy.detail.DetailMovieViewModel
import com.thorin.ngemovieeuy.home.HomeMovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<FilmUseCase> { FilmInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeMovieViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}