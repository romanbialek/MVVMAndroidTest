package com.romanbialek.mvvmtest.presentation.characterlist

import android.view.View
import com.romanbialek.mvvmtest.domain.model.Character


interface OnCharactersListAdapterListener {

    fun showCharacter(view: View, character: Character)
}