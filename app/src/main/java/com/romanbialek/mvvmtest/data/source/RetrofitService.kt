package com.romanbialek.mvvmtest.data.source

import com.romanbialek.mvvmtest.domain.model.GetCharactersListResponse
import com.romanbialek.mvvmtest.domain.model.base.BaseResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("characters")
    fun getCharacters(
        @Query("offset")  offset: Int?
    ): Single<BaseResponse<GetCharactersListResponse>>
}