package com.vanegas1.parcial.ui.phone.newphone

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.vanegas1.parcial.databinding.FragmentNewPhoneBinding
import com.vanegas1.parcial.ui.phone.viewmodel.PhoneViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [NewPhoneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

    class NewPhoneFragment : Fragment() {
        private val viewModel: PhoneViewModel by activityViewModels {
            PhoneViewModel.Factory
        }

        private lateinit var binding: FragmentNewPhoneBinding

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentNewPhoneBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            setViewModel()
            observeStatus()
        }

        private fun setViewModel() {
            binding.viewmodel = viewModel
        }

        private fun observeStatus() {
            viewModel.status.observe(viewLifecycleOwner) { status ->
                when {
                    status.equals(PhoneViewModel.WRONG_INFORMATION) -> {
                        Log.d("APP_TAG", status)
                        viewModel.clearStatus()
                    }

                    status.equals(PhoneViewModel.PHONE_CREATED) -> {
                        Log.d("APP_TAG", status)
                        Log.d("APP_TAG", viewModel.getPhones().toString())
                        viewModel.clearData()

                        viewModel.clearStatus()
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }