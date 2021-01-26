package com.example.revisaochamadaap.api

import com.example.revisaochamadaap.utils.Constants.Api.API_AUTH_NAME
import com.example.revisaochamadaap.utils.Constants.Api.API_AUTH_VALUE
import com.example.revisaochamadaap.utils.Constants.Api.API_CONTENT_TYPE_NAME
import com.example.revisaochamadaap.utils.Constants.Api.API_CONTENT_TYPE_VALUE
import com.example.revisaochamadaap.utils.Constants.Api.BASE_URL_TMDB
import com.example.revisaochamadaap.utils.Constants.Api.QUERY_PARAM_LANGUAGE_LABEL
import com.example.revisaochamadaap.utils.Constants.Api.QUERY_PARAM_LANGUAGE_VALUE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val tmdbApi = getTmdbMovies().create(TmdbApi::class.java)

    private fun getTmdbMovies(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_TMDB)
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        val interceptor = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor{chain ->
                val newRequest = chain.request().newBuilder()
                        //valores comum a todas as chamadas
                    .addHeader(API_AUTH_NAME, API_AUTH_VALUE)
                    .addHeader(API_CONTENT_TYPE_NAME, API_CONTENT_TYPE_VALUE)
                    .build()
                chain.proceed(newRequest)
            }
                //fixar o idioma do app
            .addInterceptor { chain ->
                val url = chain.request().url().newBuilder()
                .addQueryParameter(QUERY_PARAM_LANGUAGE_LABEL,QUERY_PARAM_LANGUAGE_VALUE)
                .build()
                val newRequest = chain.request().newBuilder().url(url).build()
                chain.proceed(newRequest)
            }
        return interceptor.build()
    }
}