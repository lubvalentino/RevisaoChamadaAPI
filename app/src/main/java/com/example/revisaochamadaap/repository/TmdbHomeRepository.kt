package com.example.revisaochamadaap.repository

import com.example.revisaochamadaap.api.ApiService
import com.example.revisaochamadaap.api.ResponseApi

class TmdbHomeRepository {

    suspend fun getTopRated(): ResponseApi {
        return try {
            val response = ApiService.tmdbApi.movies()
            if (response.isSuccessful){
                ResponseApi.Success(response.body())
            }else{
                ResponseApi.Error("Erro ao carregar os dados")
            }
        }catch (exception: Exception){
            ResponseApi.Error("Erro ao carregar os dados")
        }
    }
}