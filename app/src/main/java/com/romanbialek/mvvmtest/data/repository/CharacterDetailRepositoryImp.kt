package com.romanbialek.mvvmtest.data.repository

import com.romanbialek.mvvmtest.data.source.RetrofitService
import com.romanbialek.mvvmtest.domain.model.Character
import com.romanbialek.mvvmtest.domain.repository.CharacterDetailRepository
import com.romanbialek.mvvmtest.domain.repository.CharactersListRepository
import io.reactivex.Single


/**
 * This repository is responsible for
 * fetching data[CharacterDetail] from server
 * */
class CharacterDetailRepositoryImp(
    private val retrofitService: RetrofitService
) : CharacterDetailRepository {

    override fun getCharacter(id: Long?): Single<Character> {
        return retrofitService.getCharacterDetail(id!!)
    }
}