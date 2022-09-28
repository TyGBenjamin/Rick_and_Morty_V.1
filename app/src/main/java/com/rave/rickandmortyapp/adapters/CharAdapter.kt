package com.rave.rickandmortyapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rave.rickandmortyapp.HomeFragment
import com.rave.rickandmortyapp.databinding.ItemListBinding
import com.rave.rickandmortyapp.models.Character


class CharAdapter():RecyclerView.Adapter<CharAdapter.CharViewHolder>() {

    private var charData: List<Character> = emptyList()

    class CharViewHolder(
        private val binding: ItemListBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun apply(item: Character){
            binding.tvName.text = item.name
            binding.imageView.load(item.image)
            binding.tvStatus.text = item.status
            binding.tvRace.text = item.species
            binding.tvLocation.text = item.location?.name
            binding.tvEpisode.text = item.episode?.get(0)?.name

//            binding.cardview.setOnClickListener{clickListener.onClick(item)}
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(from, parent, false)
        return CharViewHolder(binding)

    }


    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        val currentItem = charData[position]
        holder.apply(currentItem)


    }

    override fun getItemCount(): Int {
        return charData.size
    }

    fun addData(items: List<Character>){
        this.charData = items
        notifyDataSetChanged()
    }

}
