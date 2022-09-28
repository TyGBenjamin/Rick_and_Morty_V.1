package com.rave.rickandmortyapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import coil.load
import com.rave.rickandmortyapp.adapters.CharAdapter
import com.rave.rickandmortyapp.databinding.FragmentCharacterDetailBinding
import com.rave.rickandmortyapp.models.Character
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharacterDetail : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding: FragmentCharacterDetailBinding get() = _binding!!
    private val viewModel by viewModels<CharacterDetailViewModel>()

    //    private val args by navArgs<CharacterDetailArgs>()
    private val args: CharacterDetailArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharacterDetailBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        lifecycleScope.launch {
        val myId = args.id
        viewModel.getCharacterDetails(myId)


            viewModel.viewState.collectLatest { char ->
                tvName.text = char?.name
                imageView2.load(char?.image)
                tvRace.text = char?.species
                tvEpisode.text = char?.created
                tvStatus.text = char?.status
                textView5.text = char?.gender
                textView7.text = char?.type
                tvLocation.text = char?.location?.name

            }
        }
    }
}

//viewModel.viewState.observe(viewLifecycleOwner) { char ->
//    tvName.text = char?.name
//    imageView2.load(char?.image)
//}