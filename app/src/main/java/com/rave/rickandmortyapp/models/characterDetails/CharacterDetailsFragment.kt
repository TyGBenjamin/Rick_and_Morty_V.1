package com.rave.rickandmortyapp.models.characterDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.rave.rickandmortyapp.databinding.FragmentCharacterDetailsBinding
import com.rave.rickandmortyapp.models.Location
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharacterDetailsFragment : Fragment() {
    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding: FragmentCharacterDetailsBinding get() = _binding!!
    private val viewModel by viewModels<CharacterDetailsViewModel>()
    private val safeArgs: CharacterDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharacterDetailsBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        lifecycleScope.launch {
            viewModel.populateCharacter(safeArgs.characterString)
            viewModel.char.collectLatest { char ->
                textView.text = char?.name
                imageView.load(char?.image)
                textView2.text = "Status: " + char?.status
                textView3.text = "Species: " + char?.species
                textView4.text = "Gender: " + char?.gender
                val origin: Location? = char?.origin
                textView6.text = "Name: " + origin?.name
                textView7.text = "Type: " + origin?.type
                textView8.text = "Dimension: " + origin?.dimension
                val location: Location? = char?.location
                textView10.text = "Name: " + location?.name
                textView11.text = "Type: " + location?.type
                textView12.text = "Dimension: " + location?.dimension
            }
        }

    }

}