package com.romanbialek.mvvmtest.presentation.characterlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.romanbialek.mvvmtest.R
import com.romanbialek.mvvmtest.databinding.ActivityCharactersListBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer

@AndroidEntryPoint
class CharactersListActivity : AppCompatActivity() {

    private lateinit var activityCharactersListBinding: ActivityCharactersListBinding
    private val viewModel: CharactersListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityCharactersListBinding = DataBindingUtil.setContentView(this, R.layout.activity_characters_list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activityCharactersListBinding.charactersListViewModel = viewModel

        viewModel.getCharacters()
        viewModel.charactersReceivedLiveData.observe(this, Observer {
            //activityPhotoDetailBinding.detailTitleTextView.text = it?.title

        })


    }
}