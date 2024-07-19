package com.feirapp.feirapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.feirapp.feirapp.R
import com.feirapp.feirapp.databinding.FragmentMainMenuBinding
import com.feirapp.feirapp.fragments.modals.EditItemModal
import com.feirapp.feirapp.models.enums.MeasureUnitEnum
import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel
import com.feirapp.feirapp.models.groceryItem.responses.GetGroceryItemResponse
import com.feirapp.feirapp.testHelpers.generateGroceryItems
import com.feirapp.feirapp.testHelpers.generateStoreItems
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainMenuFragment : Fragment() {
    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentMainMenuBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val testModal = binding.clTestModal
        val modalBehavior = BottomSheetBehavior.from(testModal)
        modalBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        binding.btCreateProduct.setOnClickListener {
            val directions = MainMenuFragmentDirections.goToCreateProduct()
            findNavController().navigate(directions)
        }
        binding.btSearchProducts.setOnClickListener {
            val directions = MainMenuFragmentDirections.goToSearchProducts()
            findNavController().navigate(directions)
        }
        binding.btCreateList.setOnClickListener {
            val directions = MainMenuFragmentDirections.goToCreateList()
            findNavController().navigate(directions)
        }
        binding.btImportList.setOnClickListener {
            val directions = MainMenuFragmentDirections.goToImportTypeSelectionFragment()
            findNavController().navigate(directions)
        }

        binding.btTestModal1.setOnClickListener {
            modalBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        }

        binding.btTestModal2.setOnClickListener {
            val invoice = GetGroceryItemResponse(generateStoreItems(), generateGroceryItems())
            val directions = MainMenuFragmentDirections.goToQrcodeScanResultFragment(invoice)
            findNavController().navigate(directions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
