package com.rave.rickandmortyapp.models.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rave.rickandmortyapp.databinding.CharacterCardBinding
import com.rave.rickandmortyapp.models.Character

class DashboardAdapter(
    var characters: List<Character>,
    private val navigateToDetails: (characterString: String) -> Unit
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: CharacterCardBinding,
        private val navigateToDetails: (characterString: String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun applyItem(character: Character) = with(binding) {
            tvName.text = character.name
            tvStatus.text = character.status
            tvSpecies.text = character.species
            ivAvatar.load(character.image)

            binding.root.setOnClickListener() {
                navigateToDetails(character.id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CharacterCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, navigateToDetails)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.applyItem(characters[position])
    }


}