package com.romanbialek.mvvmtest.presentation.characterdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.romanbialek.mvvmtest.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
    }
}