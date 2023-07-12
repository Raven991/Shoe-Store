package com.udacity.shoestore.models

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailShoeBinding
import com.udacity.shoestore.databinding.FragmentSheoListBinding
import com.udacity.shoestore.databinding.ListItemBinding

class DetailShoeFragment : Fragment() {
    private lateinit var binding: FragmentDetailShoeBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_shoe, container, false)

        binding.lifecycleOwner = this
        binding.shoeListingsViewModel = viewModel
        binding.shoeDetail = Shoe("",0.0,"","")

        binding.save.setOnClickListener { view: View ->
            viewModel.addShoe(viewModel.shoe)
            view.findNavController()
                .navigate(DetailShoeFragmentDirections.actionDetailShoeFragmentToSheoListFragment())
        }
        binding.cancel.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(DetailShoeFragmentDirections.actionDetailShoeFragmentToSheoListFragment())
        }
        return binding.root
    }
}