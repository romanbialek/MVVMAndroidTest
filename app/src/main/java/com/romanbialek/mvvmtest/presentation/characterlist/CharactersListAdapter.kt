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

/**
 * This class is responsible for converting each data entry [Characters]
 * into [CharacteViewHolder] that can then be added to the AdapterView.
 */
internal class CharactersListAdapter(val mListener: OnCharactersListAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = CharactersListAdapter::class.java.name
    private val characters: MutableList<Character> = ArrayList()


    /**
     * This method is called right when adapter is created &
     * is used to initialize ViewHolders
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val charactersListBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.holder_character_list_item, parent, false
        )
        return CharacterViewHolder(charactersListBinding)
    }

    /** It is called for each ViewHolder to bind it to the adapter &
     * This is where we pass data to ViewHolder
     * */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CharacterViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Character {
        return characters[position]
    }

    /**
     * This method returns the size of collection that contains the items we want to display
     * */
    override fun getItemCount(): Int {
        return characters.size
    }

    fun addData(list: List<Character>) {
        this.characters.clear()
        this.characters.addAll(list)
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
                mListener.showCharacter(character)
            }
        }
    }

}
