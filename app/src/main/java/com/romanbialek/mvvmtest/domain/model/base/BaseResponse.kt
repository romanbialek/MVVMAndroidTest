package com.romanbialek.mvvmtest.domain.model.base


data class BaseResponse<T>(
    val copyright: String,
    val code: String,
    val data: T,
    val attributionHTML: String,
    val attributionText: String,
    val etag: String, val status: String
)