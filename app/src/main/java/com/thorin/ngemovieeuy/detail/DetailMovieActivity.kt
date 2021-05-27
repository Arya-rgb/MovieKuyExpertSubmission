package com.thorin.ngemovieeuy.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.thorin.core.domain.model.Film
import com.thorin.ngemovieeuy.R
import com.thorin.ngemovieeuy.databinding.ActivityDetailMovieBinding
import com.thorin.ngemovieeuy.databinding.ContentScrollingBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var contentBinding: ContentScrollingBinding
    private val detailFilmViewModel: DetailMovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        contentBinding = binding.detailMovie

        val detailMovie = intent.getParcelableExtra<Film>(EXTRA_DATA)
        showMovieDetail(detailMovie)

    }

    private fun showMovieDetail(detailFilm: Film?) {
        detailFilm?.let {

            supportActionBar?.title = null

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w185/${detailFilm.backdrop_path}")
                .into(binding.backdropPath)

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w185/${detailFilm.poster_path}")
                .into(contentBinding.image)

            contentBinding.releaseDate.text = detailFilm.release_date
            contentBinding.movieRateDetail.text = StringBuilder("Rate ${detailFilm.vote_average} From ${detailFilm.vote_count} Users")
            contentBinding.populariry.text = StringBuilder("Popularity ${detailFilm.popularity}")
            contentBinding.titleMovie.text = detailFilm.title
            contentBinding.overview.text = detailFilm.overview

            var statusFavorite = detailFilm.isFavorite
            setStatusFavorite(statusFavorite)

            binding.fabFavorite.setOnClickListener {
                statusFavorite = !statusFavorite
                detailFilmViewModel.setFavoriteMovie(detailFilm, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

            binding.progressBar2.visibility = View.INVISIBLE

        }
    }
    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
        } else {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))
        }
    }
}