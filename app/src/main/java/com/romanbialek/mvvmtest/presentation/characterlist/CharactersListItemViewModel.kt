package com.romanbialek.mvvmtest.presentation.characterlist

import androidx.lifecycle.MutableLiveData
import com.romanbialek.mvvmtest.domain.model.Character

/**A helper class for the UI controller that is responsible for
 * preparing data for [CharactersListItemViewModel] as the UI
 * */
class CharactersListItemViewModel(val character: Character) {

    private val TAG = CharactersListItemViewModel::class.java.simpleName
    val characterData = MutableLiveData<Character>()

    init {
        characterData.value = character
    }

}