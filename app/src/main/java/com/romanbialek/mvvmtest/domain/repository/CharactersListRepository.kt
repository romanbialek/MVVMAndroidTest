package com.romanbialek.mvvmtest.domain.repository

import com.romanbialek.mvvmtest.domain.model.Character
import com.romanbialek.mvvmtest.domain.model.GetCharactersListResponse
import com.romanbialek.mvvmtest.domain.model.base.BaseResponse
import io.reactivex.Single

/**
 * To make an interaction between [AlbumRepositoryImp] & [GetAlbumsUseCase]
 * */
interface CharactersListRepository {

    fun getCharacters(): Single<BaseResponse<GetCharactersListResponse>>//Single<List<Character>>
}