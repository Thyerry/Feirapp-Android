package com.feirapp.feirapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.feirapp.feirapp.databinding.FragmentQrcodeScanResultBinding

class QrcodeScanResultFragment : Fragment() {
    private var _binding: FragmentQrcodeScanResultBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<QrcodeScanResultFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View? {
        _binding = FragmentQrcodeScanResultBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val groceryItems = args.grocerryItemList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}