package com.thorin.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListDataResponse(

    @field:SerializedName("results")
    val results: List<DataResponse>
)
