package com.rave.rickandmortyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.rave.rickandmortyapp.databinding.FragmentCharcaterDetailBinding

class Charcater_Detail_Fragment : Fragment() {
    private var _binding: FragmentCharcaterDetailBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<Charcater_Detail_FragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharcaterDetailBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = "Character ID: ${args.characterId}"
        binding.tvHello.text = text
    }
}