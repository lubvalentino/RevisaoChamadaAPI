package com.example.revisaochamadaap.paging

import android.content.Context
import androidx.paging.PageKeyedDataSource
import com.example.revisaochamadaap.api.ResponseApi
import com.example.revisaochamadaap.database.TmdbDatabase
import com.example.revisaochamadaap.extensions.getFullImagePath
import com.example.revisaochamadaap.model.Result
import com.example.revisaochamadaap.model.TopRated
import com.example.revisaochamadaap.repository.TmdbHomeRepository
import com.example.revisaochamadaap.utils.Constants.Paging.FIRST_PAGE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Response

//Essa classe será a business
class TmdbPageKeyedDataSource (
    private val context:Context
        ) : PageKeyedDataSource<Int,Result>() {

    private val repository by lazy {
        TmdbHomeRepository()
    }
    //load inicial => a página 1
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        //vai chamar uma thread separada
        CoroutineScope(IO).launch {
            when (val response = repository.getTopRated(FIRST_PAGE)){
                is ResponseApi.Success -> {
                    val data = response.data as TopRated
                    data.results.forEach {
                        it.posterPath = it.posterPath.getFullImagePath()
                    }
                    val movieDao = TmdbDatabase.getDatabase(context).movieDao()
                    movieDao.getAllMovies()

                    //onde falo pra apresentar para o usuário
                    callback.onResult(data.results, null, FIRST_PAGE+1)
                }
                is ResponseApi.Error -> {
                    callback.onResult(mutableListOf(), null, FIRST_PAGE+1)
                }
            }
        }
    }

    //busca a página anterior automaticamente
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        val page = params.key

        CoroutineScope(IO). launch {
            when (val response = repository.getTopRated(page)){
                is ResponseApi.Success -> {
                    val data = response.data as TopRated
                    data.results.forEach {
                        it.posterPath = it.posterPath.getFullImagePath()
                    }
                    callback.onResult(data.results,page-1)
                }
                is ResponseApi.Error ->{
                    callback.onResult(mutableListOf(), page-1)
                }
            }
        }
    }

    //vai chamar as próximas páginas
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        val page = params.key

        CoroutineScope(IO).launch {
            when(val response = repository.getTopRated(page)){
                is ResponseApi.Success -> {
                    val data = response.data as TopRated
                    data.results.forEach {
                        it.posterPath = it.posterPath.getFullImagePath()
                    }
                    callback.onResult(data.results, page+1)
                }
                is ResponseApi.Error -> {
                    callback.onResult(mutableListOf(), page+1)
                }
            }
        }
    }

}

