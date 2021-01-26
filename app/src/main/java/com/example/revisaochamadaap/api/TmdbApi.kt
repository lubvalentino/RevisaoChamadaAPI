package com.example.revisaochamadaap.api

import com.example.revisaochamadaap.model.TopRated
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {

    //forma de passar já fixando a página que vai aparecer, nesse caso a 1
//    @GET("movie/top_rated?language=pt-BR&page=1")
//    suspend fun movies():Response<TopRated>

    @GET ("movie/top_rated")
    suspend fun movies(
        //forma de passar pegando todas páginas
        @Query("page") pageNumber: Int
    ):Response<TopRated>

    @GET("movie/{movie_id}")
    suspend fun movieDetails(
        //forma de declarar quando vai ser dado o valor, nesse caso o movieId
        @Path ("movie_id") movieId: Int
    ):Response<Any>
}