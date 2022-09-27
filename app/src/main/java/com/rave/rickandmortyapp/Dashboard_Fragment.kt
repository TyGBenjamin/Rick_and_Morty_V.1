package com.rave.rickandmortyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.rave.rickandmortyapp.adapters.CharcaterAdapter
import com.rave.rickandmortyapp.databinding.FragmentDashboardBinding
import com.rave.rickandmortyapp.models.Character

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [Dashboard_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Dashboard_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy { FragmentDashboardBinding.inflate(layoutInflater)  }
    private val viewModel by viewModels<ViewModel>()
    private val charcaterAdapter by lazy {CharcaterAdapter()}




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
        initViews()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        val view = inflater.inflate(R.layout.fragment_dashboard_, container, false)
//        val navButton = view.findViewById<Button>(R.id.button)
//        navButton.setOnClickListener {
//            findNavController().navigate(R.id.action_dashboard_Fragment_to_charcater_detail_Fragment)
//        }
//        return view

       //binding = FragmentDashboardBinding.inflate(inflater, container, false)

        return binding.root
    }

    fun initViews()= with(binding){
        rvView.adapter = charcaterAdapter
        viewModel.viewState.observe(this@Dashboard_Fragment){ viewState ->
           charcaterAdapter.addData(viewState as List<Character>)
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
            Dashboard_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}