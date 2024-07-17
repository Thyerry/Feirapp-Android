package com.feirapp.feirapp.fragments.modals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.feirapp.feirapp.databinding.EditItemModalBinding
import com.feirapp.feirapp.extensions.toast
import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EditItemModal(private val item: GroceryListItemModel) : BottomSheetDialogFragment() {
    private var _binding: EditItemModalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = EditItemModalBinding.inflate(inflater, group, false)
        binding.apply {
            tvItemName.text = item.name
            btSave.setOnClickListener {
                requireActivity().toast("Item salvo com sucesso")
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val TAG = "EditItemModal"

        fun start(manager: FragmentManager, item: GroceryListItemModel) {
            EditItemModal(item).show(manager, TAG)
        }
    }
}
