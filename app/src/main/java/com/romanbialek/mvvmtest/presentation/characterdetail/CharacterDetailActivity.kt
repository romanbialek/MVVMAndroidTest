package com.romanbialek.mvvmtest.presentation.characterdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.romanbialek.mvvmtest.R
import com.romanbialek.mvvmtest.presentation.characterlist.CharactersListViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil

import com.romanbialek.mvvmtest.databinding.ActivityCharacterDetailBinding
import javax.inject.Inject

@AndroidEntryPoint
class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var activityCharacterDetailBinding: ActivityCharacterDetailBinding
    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
    }
}