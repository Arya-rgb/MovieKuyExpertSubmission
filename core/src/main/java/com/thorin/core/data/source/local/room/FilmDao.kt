package com.thorin.core.data.source.local.room

import androidx.room.*
import com.thorin.core.data.source.local.entity.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Query("SELECT * FROM favorite_film")
    fun getAllMovie(): Flow<List<FilmEntity>>

    @Query("SELECT * FROM favorite_film WHERE isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<FilmEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: List<FilmEntity>)

    @Update
    fun updateFavoriteFilm(film: FilmEntity)

}