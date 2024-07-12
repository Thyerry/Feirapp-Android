package com.feirapp.feirapp.models

import android.os.Parcelable
import com.google.mlkit.vision.barcode.common.Barcode
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScanBarcodeCallback (
    var onScan: ((barcodes: List<Barcode>) -> Unit)? = null
) : Parcelable