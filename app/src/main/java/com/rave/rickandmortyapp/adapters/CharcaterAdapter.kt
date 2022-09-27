package com.rave.rickandmortyapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rave.rickandmortyapp.databinding.ViewHolderBinding
import com.rave.rickandmortyapp.models.Character

class CharcaterAdapter(
    private val navigateToDetails: (characterId: String) -> Unit
):RecyclerView.Adapter<CharcaterAdapter.CharcaterAdapterViewHolder>() {

  private var data: List<Character> = emptyList()

    class CharcaterAdapterViewHolder(
    private val binding: ViewHolderBinding,
    private val navigateToDetails: (characterId: String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root){
        fun applyItem(item: Character){
            binding.imageView.load(item.image)
            binding.tvName.text = item.name
            binding.tvRace.text = item.species
            binding.tvLocation.text = item.location?.name

            binding.tvEpisode.text = item.episode?.get(0)?.name

            binding.root.setOnClickListener {
                navigateToDetails(item.id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharcaterAdapterViewHolder {
        val binding = ViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharcaterAdapterViewHolder(binding, navigateToDetails)
    }

    override fun onBindViewHolder(holder: CharcaterAdapterViewHolder, position: Int) {
        val item = data[position]
        holder.applyItem(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addData(items: List<Character>){
        this.data = items
       notifyDataSetChanged()
    }
}