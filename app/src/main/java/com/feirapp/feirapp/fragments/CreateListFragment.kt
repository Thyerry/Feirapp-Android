package com.feirapp.feirapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.feirapp.feirapp.databinding.FragmentCreateListBinding
import com.feirapp.feirapp.fragments.modals.AdvancedSearchModal
import com.feirapp.feirapp.helpers.Utils
import com.feirapp.feirapp.models.groceryItem.queries.SearchGroceryItemQuery
import com.feirapp.feirapp.models.groceryItem.responses.SearchGroceryItemResponse
import com.feirapp.feirapp.network.RetrofitClient
import com.google.android.material.snackbar.Snackbar
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class CreateListFragment : Fragment() {
    private var _binding: FragmentCreateListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentCreateListBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiService = RetrofitClient.create()

        _binding?.btSearchProducts!!.setOnClickListener {
            Utils.NotImplYet(this.requireView())
            val call = apiService.getGroceryItems(SearchGroceryItemQuery(null, 0, 0, 10))

            call.enqueue(object : Callback<List<SearchGroceryItemResponse>> {
                override fun onResponse(
                    call: Call<List<SearchGroceryItemResponse>>,
                    response: Response<List<SearchGroceryItemResponse>>
                ) {
                    Snackbar.make(view, "Funcionou", Snackbar.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<List<SearchGroceryItemResponse>>, t: Throwable) {
                    Snackbar.make(view, "Não Funcionou", Snackbar.LENGTH_SHORT).show()
                }
            })
        }
        _binding?.btMoreOptions!!.setOnClickListener {
            AdvancedSearchModal.start(this.parentFragmentManager)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}