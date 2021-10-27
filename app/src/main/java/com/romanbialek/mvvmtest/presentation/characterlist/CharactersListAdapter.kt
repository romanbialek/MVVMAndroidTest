package com.romanbialek.mvvmtest.presentation.characterlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.romanbialek.mvvmtest.domain.model.Character
import com.romanbialek.mvvmtest.R
import com.romanbialek.mvvmtest.databinding.HolderCharacterListItemBinding
import com.romanbialek.mvvmtest.presentation.loadImage
import java.util.*


internal class CharactersListAdapter(val mListener: OnCharactersListAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = CharactersListAdapter::class.java.name
    private val characters: MutableList<Character> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val charactersListBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.holder_character_list_item, parent, false
        )
        return CharacterViewHolder(charactersListBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CharacterViewHolder).onBind(getItem(position))
    }

    fun getItem(position: Int): Character {
        return characters[position]
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    fun addData(index: Int, list: List<Character>) {
        this.characters.addAll(index, list)
        notifyDataSetChanged()
    }


    inner class CharacterViewHolder(private val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root) {

        fun onBind(character: Character) {
            val characterItemBinding = dataBinding as HolderCharacterListItemBinding
            val characterListItemViewModel = CharactersListItemViewModel(character)
            characterItemBinding.charactersListItemViewModel = characterListItemViewModel
            if(character.thumbnail != null) {
                var url = character.thumbnail.path!! + "." + character.thumbnail.extension!!
                characterItemBinding.thumbnailImage.loadImage(url)
            }

            itemView.setOnClickListener {
                mListener.showCharacter(characterItemBinding.thumbnailImage, character)
            }
        }
    }

}
