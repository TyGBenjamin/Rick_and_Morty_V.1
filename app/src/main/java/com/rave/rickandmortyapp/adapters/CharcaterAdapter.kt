package com.rave.rickandmortyapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rave.rickandmortyapp.databinding.ViewHolderBinding
import com.rave.rickandmortyapp.models.Character

class CharcaterAdapter():RecyclerView.Adapter<CharcaterAdapter.CharcaterAdapterViewHolder>() {

  private var data: List<Character> = emptyList()

    class CharcaterAdapterViewHolder(
    private val binding: ViewHolderBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun applyItem(item: Character){
            binding.tvItem.text = item.name + " is " + item.gender

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharcaterAdapterViewHolder {
        val binding = ViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharcaterAdapterViewHolder(binding)

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