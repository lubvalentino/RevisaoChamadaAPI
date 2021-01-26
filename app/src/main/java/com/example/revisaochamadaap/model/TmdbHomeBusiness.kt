package com.example.revisaochamadaap.model

import com.example.revisaochamadaap.utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE
import com.example.revisaochamadaap.api.ResponseApi
import com.example.revisaochamadaap.repository.TmdbHomeRepository

class TmdbHomeBusiness {

//    essa classe não é usada no paging
//    private val repository by lazy {
//        TmdbHomeRepository()
//    }
//    suspend fun getTopRated():ResponseApi{
//        val response =  repository.getTopRated()
//        //essa verificação está sendo feita somente porque vamos trocar algo no dado,
//        //caso contrário era só fazer return repository.getTopRated()
//        return if (response is ResponseApi.Success){
//            val topRated = response.data as TopRated
//            topRated.results.firstOrNull()?.title = "Teste 123"
//            topRated.results.forEach {
//                it.posterPath = "$BASE_URL_ORIGINAL_IMAGE${it.posterPath}"
//            }
//            ResponseApi.Success(topRated)
//        } else{
//            response
//        }
//    }


}