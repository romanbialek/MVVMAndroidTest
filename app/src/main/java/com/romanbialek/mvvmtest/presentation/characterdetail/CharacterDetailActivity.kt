package com.romanbialek.mvvmtest.presentation.characterdetail

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.romanbialek.mvvmtest.R
import com.google.gson.Gson
import com.romanbialek.mvvmtest.databinding.ActivityCharacterDetailBinding
import com.romanbialek.mvvmtest.domain.model.Character
import com.romanbialek.mvvmtest.presentation.loadImage

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var activityCharacterDetailBinding: ActivityCharacterDetailBinding
    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gson = Gson()
        val character = gson.fromJson(intent.getStringExtra("character"), Character::class.java)
        activityCharacterDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_character_detail)

        if(character.thumbnail != null) {
            activityCharacterDetailBinding.imageView.loadImage(character.thumbnail!!.path + '.' + character.thumbnail.extension)
        }
        activityCharacterDetailBinding.detailName.text = character.name
        activityCharacterDetailBinding.detailDescription.text = character.description
        if (character.description.isNullOrEmpty())
            activityCharacterDetailBinding.detailDescription.visibility = View.GONE
        activityCharacterDetailBinding.detailComics.text = getString(R.string.comics) + "  " + character.comicsResponse.available.toString()
        activityCharacterDetailBinding.detailEvents.text = getString(R.string.events) + "  " + character.eventsResponse.available.toString()
        activityCharacterDetailBinding.detailSeries.text = getString(R.string.series) + "  " + character.seriesResponse.available.toString()
        activityCharacterDetailBinding.detailStories.text = getString(R.string.stories) + "  " +  character.storiesResponse.available.toString()


    }
}