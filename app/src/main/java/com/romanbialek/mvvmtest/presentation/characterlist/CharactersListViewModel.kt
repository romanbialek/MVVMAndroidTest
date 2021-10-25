package com.romanbialek.mvvmtest.presentation.characterlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.romanbialek.mvvmtest.domain.usecase.GetCharactersUseCase
import com.romanbialek.mvvmtest.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * A helper class for the UI controller that is responsible for
 * preparing data for [CharactersListActivity]
 *
 * */
@HiltViewModel
class CharactersListViewModel @Inject constructor(private val getCharactersListUseCase: GetCharactersUseCase) : ViewModel() {

    private val TAG = CharactersListViewModel::class.java.simpleName
    val isLoad = MutableLiveData<Boolean>()
    val charactersReceivedLiveData = MutableLiveData<List<Character>>()

    init {
        isLoad.value = false
    }

    fun getCharacters() {
        getCharactersListUseCase.execute(
            onSuccess = {
                isLoad.value = true
                charactersReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

}