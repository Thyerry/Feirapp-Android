package com.feirapp.feirapp.fragments.modals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.FragmentManager
import com.feirapp.feirapp.EditBrandAndAltNameCallback
import com.feirapp.feirapp.databinding.EditItemModalBinding
import com.feirapp.feirapp.extensions.toast
import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EditItemModal(
    private var item: GroceryListItemModel,
    private var submitItemEdit: ((item: GroceryListItemModel) -> Unit)?
) : BottomSheetDialogFragment() {

    private var _binding: EditItemModalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = EditItemModalBinding.inflate(inflater, group, false)

        binding.apply {
            tvItemName.text = item.name
            tietAltName.setText(item.altName)
            tietBrandName.setText(item.brand)
            btSave.setOnClickListener {
                requireActivity().toast("Item salvo com sucesso")
            }
        }

        binding.tietAltName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                binding.tilBrandName.requestFocus()
                true
            } else {
                false
            }
        }

        binding.tietBrandName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.tilBrandName.clearFocus()
                binding.tietBrandName.clearFocus()
                true
            } else {
                false
            }
        }

        binding.btSave.setOnClickListener {
            item.altName = binding.tietAltName.text.toString()
            item.brand = binding.tietBrandName.text.toString()
            this.submitItemEdit?.invoke(item)
            this.dismiss()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val TAG = "EditItemModal"

        fun start(manager: FragmentManager, item: GroceryListItemModel, callback: EditBrandAndAltNameCallback) {
            EditItemModal(item, callback.onEditBrandAndAltNameCallback).show(manager, TAG)
        }
    }
}
