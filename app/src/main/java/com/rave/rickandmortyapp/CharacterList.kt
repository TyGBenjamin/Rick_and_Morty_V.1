package com.rave.rickandmortyapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.rave.rickandmortyapp.adapters.CharAdapter
import com.rave.rickandmortyapp.data.Resource
import com.rave.rickandmortyapp.databinding.FragmentCharacterListBinding


import com.rave.rickandmortyapp.models.Character



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class CharacterList : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private  val binding by lazy {FragmentCharacterListBinding.inflate(layoutInflater)}

    private val viewModel by viewModels<CharacterViewModel>()
//    private val charAdapter by lazy {CharAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {

        return binding.root
    }


    private fun navToDetails(characterId: String){
        val action = CharacterListDirections.actionCharacterListToCharacterDetail()
        findNavController().navigate(action)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    //
//    fun initViews() = with(binding){
//        recyclerView.adapter = mainAdapter
//        viewModel.viewState.observe(this@FirstFragment){ viewState ->
//            mainAdapter.addData(viewState as List<Character>)
//        }
//
//    }
    private fun initViews() = with(binding){
        viewModel.viewState.observe(this@CharacterList){
                viewState -> rvView.adapter = CharAdapter().apply{ addData(viewState as List<Character>)
        }

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Dashboard_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CharacterList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



}
