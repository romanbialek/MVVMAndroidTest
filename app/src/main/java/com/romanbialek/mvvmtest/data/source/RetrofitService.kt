package com.romanbialek.mvvmtest.data.source


import com.romanbialek.mvvmtest.domain.model.Character
import com.romanbialek.mvvmtest.domain.model.GetCharactersListResponse
import com.romanbialek.mvvmtest.domain.model.base.BaseResponse

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("characters")
    fun getCharacters(): Single<BaseResponse<GetCharactersListResponse>>

    @GET("character/{id}")
    fun getCharacterDetail(@Path("id") id: Long):Single<Character>
}