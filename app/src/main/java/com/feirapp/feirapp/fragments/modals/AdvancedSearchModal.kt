package com.feirapp.feirapp.fragments.modals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.feirapp.feirapp.databinding.AdvancedSearchModalBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AdvancedSearchModal: BottomSheetDialogFragment() {
    private var _binding: AdvancedSearchModalBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        group: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AdvancedSearchModalBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val TAG = "AdvancedSearchModal"

        fun start(manager: FragmentManager) {
            AdvancedSearchModal().show(manager, TAG)
        }
    }
}