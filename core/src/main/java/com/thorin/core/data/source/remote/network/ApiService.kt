package com.thorin.core.data.source.remote.network

import com.thorin.core.data.source.remote.response.ListDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/now_playing")
    suspend fun getNowPlaying(
            @Query("api_key") apiKey: String = "fb15a820ac28b3cf7bbed6ae263f5893"
    ) : ListDataResponse

}