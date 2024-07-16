package com.feirapp.feirapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.feirapp.feirapp.databinding.FragmentQrCodeScanLoadingBinding
import com.feirapp.feirapp.extensions.cameraPermissionRequest
import com.feirapp.feirapp.extensions.isPermissionGranted
import com.feirapp.feirapp.extensions.openPermissionSetting
import com.feirapp.feirapp.extensions.toast
import com.feirapp.feirapp.models.groceryItem.responses.GetGroceryItemResponse
import com.feirapp.feirapp.models.ScanBarcodeCallback
import com.feirapp.feirapp.network.RetrofitClient
import com.google.mlkit.vision.barcode.common.Barcode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QrCodeScanLoadingFragment : Fragment() {
    private var _binding: FragmentQrCodeScanLoadingBinding? = null
    private val binding get() = _binding!!

    private val cameraPermission = android.Manifest.permission.CAMERA

    private var navController: NavController? = null
    private var open: Boolean = false
    private var apiCalled: Boolean = false
    private var sefazUrl: String = ""

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                startScannerFragment()
            }
        }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentQrCodeScanLoadingBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()

        if (!open) {
            open = !this.open
            requestCameraAndStartScanner()
        }
    }

    private fun startScannerFragment() {
        val callback = ScanBarcodeCallback(
            onScan = { barcodes ->
                val qrCode = barcodes.first()
                when (qrCode.valueType) {
                    Barcode.TYPE_URL -> {
                        sefazUrl = qrCode.rawValue.toString()
                    }

                    else -> {
                        requireActivity().toast("Invalid QR Code!", LENGTH_LONG)
                    }
                }
            }
        )
        val directions = QrCodeScanLoadingFragmentDirections.goToQrcodeScanFragment(callback)
        navController?.navigate(directions)
    }

    private fun startResultFragment() {
        val apiService = RetrofitClient.create()
        val sefazCode = sefazUrl.split("?p=").last()

        apiService.getGroceryItemsFromInvoice(sefazCode).enqueue(
            object : Callback<GetGroceryItemResponse> {
                override fun onResponse(call: Call<GetGroceryItemResponse>, response: Response<GetGroceryItemResponse>) {
                    if (response.isSuccessful) {
                        try {
                            val invoice: GetGroceryItemResponse = response.body()!!
                            val directions = QrCodeScanLoadingFragmentDirections.goToQrcodeScanResultFragment(invoice)
                            navController?.navigate(directions)

                        }
                        catch (e: Exception) {
                            Log.d("MinhaException", e.message.toString())
                        }
                    }
                    else {
                        Log.d("ApiResponseError", response.raw().toString())
                        Toast.makeText(
                            requireActivity(),
                            "Erro no servidor, tente novamente mais tarde!",
                            LENGTH_LONG
                        ).show()
                        navController?.navigateUp()
                    }
                }

                override fun onFailure(call: Call<GetGroceryItemResponse>, t: Throwable) {
                    Log.d("ApiCallFailure", "$call qual o erro?")
                    Toast.makeText(
                        requireActivity(),
                        "Erro no servidor, tente novamente mais tarde!",
                        LENGTH_LONG
                    ).show()
                    navController?.navigateUp()
                }
            }
        )
    }

    private fun requestCameraAndStartScanner() {
        if (requireActivity().isPermissionGranted(cameraPermission)) {
            startScannerFragment()
        } else {
            requestCameraPermission()
        }
    }

    private fun requestCameraPermission() {
        when {
            shouldShowRequestPermissionRationale(cameraPermission) -> {
                requireActivity().cameraPermissionRequest {
                    requireActivity().openPermissionSetting()
                }
            }

            else -> {
                requestPermissionLauncher.launch(cameraPermission)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        if (sefazUrl.isNotBlank()) {
            startResultFragment()
            sefazUrl = ""
        } else if (apiCalled)
            navController?.navigateUp()
    }
}