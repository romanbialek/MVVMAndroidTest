package com.romanbialek.mvvmtest.domain.model.base

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

data class BaseResponse<T>(


    val copyright: String,
    val code: String,
    @SerializedName("data")
    val data: T,
    val attributionHTML: String,
    val attributionText: String,
    val etag: String, val status: String
)