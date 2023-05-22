package com.vanegas1.parcial.ui.phone.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vanegas1.parcial.R
import com.vanegas1.parcial.data.model.PhoneModel
import com.vanegas1.parcial.databinding.FragmentHomeBinding
import com.vanegas1.parcial.ui.phone.home.recycleview.RecycleViewAdapter
import com.vanegas1.parcial.ui.phone.viewmodel.PhoneViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class HomeFragment : Fragment() {
    private val phoneViewModel: PhoneViewModel by activityViewModels {
        PhoneViewModel.Factory
    }

    private lateinit var adapter: RecycleViewAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.addPhone.setOnClickListener {
            phoneViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newPhoneFragment)
        }
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = RecycleViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recyclerView.adapter = adapter
        displayMovie()
    }

    private fun showSelectedItem(phone: PhoneModel) {
        phoneViewModel.setSelectedPhones(phone)
        findNavController().navigate(R.id.action_homeFragment_to_phoneFragment)
    }

    private fun displayMovie() {
        adapter.setData(phoneViewModel.getPhones())
        adapter.notifyDataSetChanged()
    }
}