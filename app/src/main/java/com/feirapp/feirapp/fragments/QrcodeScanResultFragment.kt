package com.feirapp.feirapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.feirapp.feirapp.adapters.AdapterGroceryListItem
import com.feirapp.feirapp.databinding.FragmentQrcodeScanResultBinding
import com.feirapp.feirapp.extensions.toast
import com.feirapp.feirapp.helpers.Utils
import com.feirapp.feirapp.models.groceryItem.requests.InsertGroceryItemList
import com.feirapp.feirapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QrcodeScanResultFragment : Fragment() {

    private var _binding: FragmentQrcodeScanResultBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<QrcodeScanResultFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentQrcodeScanResultBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            val apiService = RetrofitClient.create()
            val store = args.invoice?.store!!
            val items = args.invoice?.items!!

            binding.apply {
                tvStoreName.text = store.name
                tvDate.text = items.first().purchaseDate
                rvQrcodeResult.layoutManager = LinearLayoutManager(requireActivity())
                rvQrcodeResult.setHasFixedSize(true)
                rvQrcodeResult.adapter = AdapterGroceryListItem(requireActivity(), items.toMutableList())
            }

            binding.btImport.setOnClickListener {
                apiService.insertGroceryList(InsertGroceryItemList(items, store))
                    .enqueue(object : Callback<Unit> {
                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            requireActivity().toast("Produtos salvos com sucesso", LENGTH_LONG)
                            findNavController().navigate(QrcodeScanResultFragmentDirections.goToMainMenuFragment())
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            Utils.NotImplYet(view)
                        }
                    })
            }
        } catch (e: Exception) {
            Log.d("Exception", e.message ?: "Unknown Error")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}