package com.romanbialek.mvvmtest.domain.repository

import com.romanbialek.mvvmtest.domain.model.Character
import io.reactivex.Single

/**
 * To make an interaction between [AlbumRepositoryImp] & [GetAlbumsUseCase]
 * */
interface CharactersListRepository {

    fun getCharacters(): Single<List<Character>>
}