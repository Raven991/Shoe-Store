package com.udacity.shoestore.models

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentSheoListBinding


class SheoListFragment : Fragment() {

    private lateinit var binding: FragmentSheoListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var shoeListingsViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_sheo_list, container, false)
        shoeListingsViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.setLifecycleOwner(this)

        binding.fab.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(SheoListFragmentDirections.actionSheoListFragmentToDetailShoeFragment2())
        }
        viewModel.getShoeLiveData().observe(viewLifecycleOwner, Observer { getshoes ->
            if (getshoes.isNotEmpty()) {
                makeShoes(getshoes)
            }
        })

        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun makeShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.list
            shoes.forEach { shoe ->
                val shoeLay = ItemShoeLayout(context)
                shoeLay.loadShoe(shoe)
                shoeContainer.addView(shoeLay)
            }
        }
    }

}