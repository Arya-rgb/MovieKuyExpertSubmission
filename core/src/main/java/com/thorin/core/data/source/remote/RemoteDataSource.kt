package com.thorin.core.data.source.remote

import android.util.Log
import com.thorin.core.data.source.remote.network.ApiResponse
import com.thorin.core.data.source.remote.network.ApiService
import com.thorin.core.data.source.remote.response.DataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    fun getAllMovieNowPlaying(): Flow<ApiResponse<List<DataResponse>>> {

        return flow {
            try {
                val response = apiService.getNowPlaying()
                val resultData = response.results
                if (resultData.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote Data Source", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}
