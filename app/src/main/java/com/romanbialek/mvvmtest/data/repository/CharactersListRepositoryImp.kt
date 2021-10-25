package com.romanbialek.mvvmtest.data.repository

import com.romanbialek.mvvmtest.data.source.RetrofitService
import com.romanbialek.mvvmtest.domain.model.Character
import com.romanbialek.mvvmtest.domain.model.GetCharactersListResponse
import com.romanbialek.mvvmtest.domain.model.base.BaseResponse
import com.romanbialek.mvvmtest.domain.repository.CharactersListRepository
import io.reactivex.Single


/**
 * This repository is responsible for
 * fetching data[CharactersList] from server
 * */
class CharactersListRepositoryImp(
    private val retrofitService: RetrofitService
) : CharactersListRepository {

    override fun getCharacters(): Single<BaseResponse<GetCharactersListResponse>> {
        return retrofitService.getCharacters()
    }
}