package com.romanbialek.mvvmtest.presentation.characterdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.romanbialek.mvvmtest.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor() : ViewModel() {
    private val TAG = CharacterDetailViewModel::class.java.simpleName
    val isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }
}