package com.example.revisaochamadaap.model

import com.google.gson.annotations.SerializedName

data class TopRated(
    val page: Int,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)