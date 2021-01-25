package com.example.revisaochamadaap.api

//classe abstrata com muito poderes, não precisa instacear para usar
sealed class ResponseApi {
    class Success (val data:Any?):ResponseApi()
    class Error (val message:String):ResponseApi()
}