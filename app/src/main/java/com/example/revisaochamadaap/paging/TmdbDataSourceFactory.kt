package com.example.revisaochamadaap.paging

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.revisaochamadaap.model.Result

class TmdbDataSourceFactory(
    private val context: Context
): DataSource.Factory<Int, Result>() {

    //criando mutable live data
    private val tmdbLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Result>>()

    override fun create(): DataSource<Int, Result> {

        //pegando nosso data source object
        val tmdbDataSource = TmdbPageKeyedDataSource(context)

        //posting the datasource to get the values
        tmdbLiveDataSource.postValue(tmdbDataSource)

        //returning the datasource
        return tmdbDataSource
    }

    //getter for itemlivedatasource
    fun getSearchLiveDataSource():MutableLiveData<PageKeyedDataSource<Int, Result>>{
        return tmdbLiveDataSource
    }

}
