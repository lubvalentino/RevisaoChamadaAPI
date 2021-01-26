package com.example.revisaochamadaap.extensions

import com.example.revisaochamadaap.utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE

fun String.getFullImagePath():String{
    return "${BASE_URL_ORIGINAL_IMAGE}${this}"
}