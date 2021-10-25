package com.romanbialek.mvvmtest.presentation.characterdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.romanbialek.mvvmtest.domain.usecase.GetCharactersUseCase
import com.romanbialek.mvvmtest.domain.model.Character
import com.romanbialek.mvvmtest.domain.usecase.GetCharacterDetailUseCase

/**
 * A helper class for the UI controller that is responsible for
 * preparing data for [PhotoDetailActivity]
 *
 * */
class CharacterDetailViewModel @ViewModelInject constructor(private val getCharacterDetailUseCase: GetCharacterDetailUseCase) : ViewModel() {

    private val TAG = CharacterDetailViewModel::class.java.simpleName
    val photoData = MutableLiveData<Character>()
    val isLoad = MutableLiveData<Boolean>()
    val isFavorite = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }




}