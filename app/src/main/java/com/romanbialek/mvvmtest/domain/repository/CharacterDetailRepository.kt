package com.romanbialek.mvvmtest.domain.repository

import com.romanbialek.mvvmtest.domain.model.Character
import io.reactivex.Single

/**
 * To make an interaction between [AlbumRepositoryImp] & [GetAlbumsUseCase]
 * */
interface CharacterDetailRepository {

    fun getCharacter(id: Long?): Single<Character>
}