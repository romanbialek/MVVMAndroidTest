package com.romanbialek.mvvmtest.presentation.characterlist

import com.romanbialek.mvvmtest.domain.model.Character

/**
 * To make an interaction between [AlbumsAdapter] & [AlbumsFragment]
 * */
interface OnCharactersListAdapterListener {

    fun showCharacter(character: Character)
}