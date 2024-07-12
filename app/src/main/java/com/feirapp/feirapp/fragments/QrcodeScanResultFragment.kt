package com.feirapp.feirapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.feirapp.feirapp.adapters.AdapterGroceryListItem
import com.feirapp.feirapp.databinding.FragmentQrcodeScanResultBinding

class QrcodeScanResultFragment : Fragment() {

    private var _binding: FragmentQrcodeScanResultBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<QrcodeScanResultFragmentArgs>()
    private lateinit var adapterGroceryListItem: AdapterGroceryListItem

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentQrcodeScanResultBinding.inflate(inflater, group, false)
        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            super.onViewCreated(view, savedInstanceState)
            adapterGroceryListItem = AdapterGroceryListItem(requireActivity(), args.invoice?.items!!.toMutableList())
            binding.tvStoreName.text = args.invoice?.store!!.name
            binding.rvQrcodeResult.layoutManager = LinearLayoutManager(requireActivity())
            binding.rvQrcodeResult.setHasFixedSize(true)
            binding.rvQrcodeResult.adapter = this.adapterGroceryListItem
            binding.btImport.setOnClickListener {
                val direction = QrcodeScanResultFragmentDirections.goToMainMenuFragment()
                findNavController().navigate(direction)
            }
        } catch (e: Exception) {
            val err = e.message
            Log.d("Exception", "$err")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}