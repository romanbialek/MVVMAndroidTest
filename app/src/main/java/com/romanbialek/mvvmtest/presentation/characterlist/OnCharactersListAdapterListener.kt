package com.romanbialek.mvvmtest.presentation.characterlist

import com.romanbialek.mvvmtest.domain.model.Character


interface OnCharactersListAdapterListener {

    fun showCharacter(character: Character)
}