package com.example.revisaochamadaap.api

import com.example.revisaochamadaap.model.TopRated
import retrofit2.Response
import retrofit2.http.GET

interface TmdbApi {

    @GET("movie/top_rated?language=pt-BR&page=1")
    suspend fun movies():Response<TopRated>
}