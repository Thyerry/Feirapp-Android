package com.feirapp.feirapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.feirapp.feirapp.databinding.FragmentImportTypeSelectionBinding


class ImportTypeSelectionFragment : Fragment() {
    private var _binding: FragmentImportTypeSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentImportTypeSelectionBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnQrCode.setOnClickListener {
            val directions = ImportTypeSelectionFragmentDirections.goToQrCodeScanLoadingFragment()
            findNavController().navigate(directions)
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}