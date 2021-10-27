package com.romanbialek.mvvmtest.presentation.characterlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.romanbialek.mvvmtest.R
import com.romanbialek.mvvmtest.databinding.ActivityCharactersListBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.romanbialek.mvvmtest.domain.model.Character
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.romanbialek.mvvmtest.presentation.characterdetail.CharacterDetailActivity
import com.google.gson.Gson

@AndroidEntryPoint
class CharactersListActivity : AppCompatActivity(), OnCharactersListAdapterListener {

    private lateinit var activityCharactersListBinding: ActivityCharactersListBinding
    private val viewModel: CharactersListViewModel by viewModels()
    private var adapter: CharactersListAdapter? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = CharactersListAdapter(this)
        activityCharactersListBinding = DataBindingUtil.setContentView(this, R.layout.activity_characters_list)
        activityCharactersListBinding.charactersListViewModel = viewModel
        recyclerView = activityCharactersListBinding.charactersRecyclerView
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this@CharactersListActivity)
        recyclerView.layoutManager = layoutManager

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = recyclerView.adapter!!.itemCount
                    if ((visibleItemCount + pastVisibleItem) == total) {
                        viewModel.isLoadFinished.value = false
                        viewModel.getCharacters(recyclerView.adapter!!.itemCount)
                    }
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel.getCharacters(0)

        viewModel.charactersReceivedLiveData.observe(this, Observer {
            adapter?.addData(adapter!!.itemCount, it)
        })

        viewModel.errorLiveData.observe(this,{
            Snackbar.make(View(this@CharactersListActivity), R.string.error_message, Snackbar.LENGTH_LONG).show()
        })

        viewModel.isLoadFinished.observe(this, Observer {
            it?.let { visibility ->
                activityCharactersListBinding.progressBar.visibility = if (visibility) View.GONE else View.VISIBLE
            }
        })

    }

    override fun onDestroy(){
        super.onDestroy()
        adapter = null
    }

    override fun showCharacter(view: View, character: Character) {
        val intent = Intent(this@CharactersListActivity, CharacterDetailActivity::class.java)
        val gson = Gson()
        val myJson = gson.toJson(character)
        intent.putExtra("character", myJson)

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            view,
            ViewCompat.getTransitionName(view) ?: ""
        )
        startActivity(intent, options.toBundle())
    }
}