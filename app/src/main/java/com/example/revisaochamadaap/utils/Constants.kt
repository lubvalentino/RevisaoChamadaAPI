package com.example.revisaochamadaap.utils

class Constants {
    object Api{
        const val BASE_URL_TMDB = "https://api.themoviedb.org/3/"
        const val API_AUTH_NAME = "Authorization"
        const val API_AUTH_VALUE = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYjgyYTAxMDg5NWI3MWY5YjY4ZjYwOTBjODRlYjE4MCIsInN1YiI6IjYwMDM0OGQwYzk5ODI2MDAzZGEzMTk4ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5MZ9Zrb-j3Rbldut5ahg34RjuLYuqXQjK-tvkGxG4vo"
        const val API_CONTENT_TYPE_NAME = "Content-Type"
        const val API_CONTENT_TYPE_VALUE = "application/json;charset=utf-8"
        const val BASE_URL_ORIGINAL_IMAGE = "https://image.tmdb.org/t/p/original"
        const val QUERY_PARAM_LANGUAGE_LABEL = "language"
        const val QUERY_PARAM_LANGUAGE_VALUE = "pt-BR"
    }

    object Paging{
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 1
    }
}