package com.romanbialek.mvvmtest.presentation.characterlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.romanbialek.mvvmtest.R
import com.romanbialek.mvvmtest.databinding.ActivityCharactersListBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer
import com.romanbialek.mvvmtest.domain.model.Character

@AndroidEntryPoint
class CharactersListActivity : AppCompatActivity(), OnCharactersListAdapterListener {

    private lateinit var activityCharactersListBinding: ActivityCharactersListBinding
    private val viewModel: CharactersListViewModel by viewModels()
    private var adapter: CharactersListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = CharactersListAdapter(this)

        activityCharactersListBinding = DataBindingUtil.setContentView(this, R.layout.activity_characters_list)
        activityCharactersListBinding.charactersListViewModel = viewModel
        activityCharactersListBinding.charactersRecyclerView.adapter = adapter

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        viewModel.getCharacters()
        viewModel.charactersReceivedLiveData.observe(this, Observer {
            initRecyclerView(it)
        })

        viewModel.isLoadFinished.observe(this, Observer {
            it?.let { visibility ->
                activityCharactersListBinding.albumsProgressBar.visibility = if (visibility) View.GONE else View.VISIBLE
            }
        })

    }

    private fun initRecyclerView(characters: List<Character>) {
        adapter?.addData(characters)
    }

    override fun onDestroy(){
        super.onDestroy()
        adapter = null
    }

    override fun showCharacter(character: com.romanbialek.mvvmtest.domain.model.Character) {
        TODO("Not yet implemented")
    }
}