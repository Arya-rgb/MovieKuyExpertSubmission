package com.thorin.core.data


import com.thorin.core.data.source.local.LocalDataSource
import com.thorin.core.data.source.remote.RemoteDataSource
import com.thorin.core.data.source.remote.network.ApiResponse
import com.thorin.core.data.source.remote.response.DataResponse
import com.thorin.core.domain.model.Film
import com.thorin.core.domain.repository.IFilmRepository
import com.thorin.core.utils.AppExecutors
import com.thorin.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FilmRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IFilmRepository {

    
    override fun getAllMovieNowPlaying(): Flow<Resource<List<Film>>> =
        object : NetworkBoundResource<List<Film>, List<DataResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Film>> {
                return localDataSource.getAllMovie().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Film>?): Boolean =
              data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<DataResponse>>> =
                remoteDataSource.getAllMovieNowPlaying()

            override suspend fun saveCallResult(data: List<DataResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(tourismList)
            }
        }.asFlow()

    override fun setFavoriteFilm(film: Film, state: Boolean) {
        val filmEntity = DataMapper.mapDomainToEntity(film)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteFilm(filmEntity, state)
        }
    }

    override fun getFavoriteMovie(): Flow<List<Film>> {
        return localDataSource.getFavoriteMovie().map { DataMapper.mapEntitiesToDomain(it) }
    }
}