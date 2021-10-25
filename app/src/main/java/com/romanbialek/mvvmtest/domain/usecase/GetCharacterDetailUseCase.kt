package com.romanbialek.mvvmtest.domain.usecase


import com.romanbialek.mvvmtest.domain.model.Character
import com.romanbialek.mvvmtest.domain.repository.CharacterDetailRepository
import com.romanbialek.mvvmtest.domain.repository.CharactersListRepository
import com.romanbialek.mvvmtest.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * An interactor that calls the actual implementation of [AlbumViewModel](which is injected by DI)
 * it handles the response that returns data &
 * contains a list of actions, event steps
 */
class GetCharacterDetailUseCase @Inject constructor(private val repository: CharacterDetailRepository) : SingleUseCase<Character>() {

    override fun buildUseCaseSingle(): Single<Character> {
        return repository.getCharacter(1)
    }
}