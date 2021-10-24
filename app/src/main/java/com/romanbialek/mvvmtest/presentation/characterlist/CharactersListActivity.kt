package com.romanbialek.mvvmtest.presentation.characterlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.romanbialek.mvvmtest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)
    }
}