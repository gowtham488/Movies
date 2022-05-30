package com.mgr.movies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mgr.movies.R
import com.mgr.movies.databinding.FragmentSelectionBinding
import com.mgr.movies.viewmodels.SelectionViewModel

class SelectionFragment : Fragment(), View.OnClickListener {

    private lateinit var viewModel: SelectionViewModel
    private lateinit var binding : FragmentSelectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SelectionViewModel::class.java]
        binding.viewModel = viewModel
        binding.movies.setOnClickListener(this)
        binding.series.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view) {
            binding.movies -> findNavController().navigate(R.id.action_selectionFragment_to_moviesFragment)
            binding.series -> findNavController().navigate(R.id.action_selectionFragment_to_seriesFragment)
        }
    }
}