package com.feirapp.feirapp.fragments.modals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feirapp.feirapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TestModal : BottomSheetDialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
        View? = inflater.inflate(R.layout.test_modal, container, false)

    companion object {
        const val TAG = "TestModal"
    }
}
