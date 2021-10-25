package com.romanbialek.mvvmtest.presentation.characterdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.romanbialek.mvvmtest.domain.usecase.GetCharactersUseCase
import com.romanbialek.mvvmtest.domain.model.Character
import com.romanbialek.mvvmtest.domain.usecase.GetCharacterDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * A helper class for the UI controller that is responsible for
 * preparing data for [PhotoDetailActivity]
 *
 * */
@HiltViewModel
class CharacterDetailViewModel @Inject constructor(private val getCharacterDetailUseCase: GetCharacterDetailUseCase) : ViewModel() {

    private val TAG = CharacterDetailViewModel::class.java.simpleName
    val photoData = MutableLiveData<Character>()
    val isLoad = MutableLiveData<Boolean>()
    val isFavorite = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }




}