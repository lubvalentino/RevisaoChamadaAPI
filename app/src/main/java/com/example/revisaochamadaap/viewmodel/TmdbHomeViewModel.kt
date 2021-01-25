package com.example.revisaochamadaap.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.revisaochamadaap.api.ResponseApi
import com.example.revisaochamadaap.model.TmdbHomeBusiness
import com.example.revisaochamadaap.model.TopRated
import kotlinx.coroutines.launch

class TmdbHomeViewModel :ViewModel() {

    val onResultTopRated: MutableLiveData<TopRated> = MutableLiveData()
    val onResultFailure: MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        TmdbHomeBusiness()
    }

    fun getTopRated() {
        viewModelScope.launch {
            when (val response = business.getTopRated()){
                is ResponseApi.Success ->{
                    onResultTopRated.postValue(
                        response.data as TopRated
                    )
                }
                is ResponseApi.Error ->{
                    onResultFailure.postValue(response.message)
                }
            }
        }

    }
}