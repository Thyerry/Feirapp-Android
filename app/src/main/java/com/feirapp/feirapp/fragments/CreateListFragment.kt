package com.feirapp.feirapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.feirapp.feirapp.databinding.FragmentCreateListBinding
import com.feirapp.feirapp.extensions.toast
import com.feirapp.feirapp.fragments.modals.AdvancedSearchModal
import com.feirapp.feirapp.helpers.Utils


class CreateListFragment : Fragment() {
    private var _binding: FragmentCreateListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentCreateListBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.btSearchProducts!!.setOnClickListener{
            Utils.NotImplYet(this.requireView())
        }
        _binding?.btMoreOptions!!.setOnClickListener{
            AdvancedSearchModal.start(this.parentFragmentManager)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}