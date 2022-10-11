package com.rave.rickandmortyapp.models.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rave.rickandmortyapp.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding: FragmentDashboardBinding get() = _binding!!
    private val viewModel by viewModels<DashboardViewModel>()
    private lateinit var dashboardAdapter: DashboardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDashboardBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    private fun initViews() = with(binding) {
        viewModel.characters.observe(viewLifecycleOwner) {
            characters -> dashboardAdapter = DashboardAdapter(characters.toMutableList(), this@DashboardFragment::navigateToDetails)
            rvDashboard.adapter = dashboardAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun navigateToDetails(characterId: String){
        val action = DashboardFragmentDirections.actionDashboardFragmentToCharacterDetailsFragment(characterId)
        findNavController().navigate(action)
    }

}