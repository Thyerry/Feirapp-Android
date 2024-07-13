package com.feirapp.feirapp.fragments

import android.annotation.SuppressLint
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
    private lateinit var adapterGroceryListItem: AdapterGroceryListItem

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentQrcodeScanResultBinding.inflate(inflater, group, false)
        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            super.onViewCreated(view, savedInstanceState)
            val apiService = RetrofitClient.create()

            val store = args.invoice?.store!!
            val items = args.invoice?.items!!

            adapterGroceryListItem =
                AdapterGroceryListItem(requireActivity(), items.toMutableList())
            binding.tvStoreName.text = store.name
            binding.rvQrcodeResult.layoutManager = LinearLayoutManager(requireActivity())
            binding.rvQrcodeResult.setHasFixedSize(true)
            binding.rvQrcodeResult.adapter = this.adapterGroceryListItem

            binding.btImport.setOnClickListener {
                val insertList = InsertGroceryItemList(items, store)
                val caller = apiService.insertGroceryList(insertList)

                caller.enqueue(object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        Utils.NotImplYet(view)
                        Toast.makeText(
                            requireActivity(),
                            "Produtos salvos com sucesso!",
                            LENGTH_LONG
                        )
                        val direction = QrcodeScanResultFragmentDirections.goToMainMenuFragment()
                        findNavController().navigate(direction)
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        Utils.NotImplYet(view)
                    }
                })
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