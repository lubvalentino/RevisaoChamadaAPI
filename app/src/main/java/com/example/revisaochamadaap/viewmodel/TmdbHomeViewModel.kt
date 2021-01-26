package com.example.revisaochamadaap.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.revisaochamadaap.model.Result
import com.example.revisaochamadaap.paging.TmdbDataSourceFactory
import com.example.revisaochamadaap.utils.Constants.Paging.PAGE_SIZE

class TmdbHomeViewModel :ViewModel() {

    //atualizado automaticamente
    var moviePagedList: LiveData<PagedList<Result>>? = null
    private var tmdbLiveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null

    init {
        val tmdbDataSourceFactory = TmdbDataSourceFactory()

        tmdbLiveDataSource = tmdbDataSourceFactory.getSearchLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
                //quantidade de páginas
            .setPageSize(PAGE_SIZE).build()

        moviePagedList = LivePagedListBuilder(tmdbDataSourceFactory,pagedListConfig).build()
    }

//    no paging não preciso dessa duas variáveis
//    val onResultTopRated: MutableLiveData<TopRated> = MutableLiveData()
//    val onResultFailure: MutableLiveData<String> = MutableLiveData()

//    não precisa da business porque o paging assume o papel
//    private val business by lazy {
//        TmdbHomeBusiness()
//    }

//    no paging não vamos precisar desse método porque o paging vai fazer automaticamente
//    fun getTopRated() {
//        viewModelScope.launch {
//            when (val response = business.getTopRated()){
//                is ResponseApi.Success ->{
//                    onResultTopRated.postValue(
//                        response.data as TopRated
//                    )
//                }
//                is ResponseApi.Error ->{
//                    onResultFailure.postValue(response.message)
//                }
//            }
//        }
//
//    }
}