package com.techzone.airlinesapp.ui.views

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.techzone.airlinesapp.databinding.AddAirlineSheetBinding
import com.techzone.airlinesapp.iterfaces.AddAirlineInterface
import com.techzone.airlinesapp.models.Airline

class AddAirLineButtonSheet(private var addAirlineInterface: AddAirlineInterface?): BottomSheetDialogFragment() {
    private var _binding: AddAirlineSheetBinding? = null
    // This property is only valid between onCreateView and
   // onDestroyView.

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //  View view = inflater.inflate(R.layout.add_airline_sheet, container, false);
        _binding  =  AddAirlineSheetBinding.inflate(inflater, container, false)
        val view: View = binding.root
        binding.cancelBtn.setOnClickListener(View.OnClickListener { dismiss() })

        binding.confirmBtn.setOnClickListener {
            if (validateAirlineForm()) {
                val airlineName = binding.airlineName.text.toString()
                val airlineCountry = binding.airlineCountry.text.toString()
                val airlineLogo = binding.airlineLogo.text.toString()
                val airlineSlogan = binding.airlineSlogan.text.toString()
                val airlineHeadquarters = binding.airlineHeadQuaters.text.toString()
                val airlineWebsite = binding.airlineWebsite.text.toString()
                val airlineEstablished = binding.airlineEstablished.text.toString()
                val airline = Airline(
                    airlineName, airlineCountry, airlineLogo, airlineSlogan,
                    airlineHeadquarters, airlineWebsite, airlineEstablished
                )
                addAirlineInterface!!.onAddAirlineClicked(airline)
                dismiss()
            }
        }
        return view
    }
    private fun validateAirlineForm(): Boolean {
        var valid = true
        val airlineName = binding.airlineName.text.toString()
        val airlineCountry = binding.airlineCountry.text.toString()
        val airlineLogo = binding.airlineLogo.text.toString()
        val airlineSlogan = binding.airlineSlogan.text.toString()
        val airlineHeadquarters = binding.airlineHeadQuaters.text.toString()
        val airlineWebsite = binding.airlineWebsite.text.toString()
        val airlineEstablished = binding.airlineEstablished.text.toString()
        if (TextUtils.isEmpty(airlineName.trim { it <= ' ' })) {
            binding.airlineName.error = "Required."
            valid = false
        } else {
            binding.airlineName.error = null
        }
        if (TextUtils.isEmpty(airlineCountry.trim { it <= ' ' })) {
            binding.airlineCountry.error = "Required."
            valid = false
        } else {
            binding.airlineCountry.error = null
        }
        if (TextUtils.isEmpty(airlineLogo.trim { it <= ' ' })) {
            binding.airlineLogo.error = "Required."
            valid = false
        } else {
            binding.airlineLogo.error = null
        }
        if (TextUtils.isEmpty(airlineSlogan.trim { it <= ' ' })) {
            binding.airlineSlogan.error = "Required."
            valid = false
        } else {
            binding.airlineSlogan.error = null
        }
        if (TextUtils.isEmpty(airlineWebsite.trim { it <= ' ' })) {
            binding.airlineWebsite.error = "Required."
            valid = false
        } else {
            binding.airlineWebsite.error = null
        }
        if (TextUtils.isEmpty(airlineHeadquarters.trim { it <= ' ' })) {
            binding.airlineHeadQuaters.error = "Required."
            valid = false
        } else {
            binding.airlineHeadQuaters.error = null
        }
        if (TextUtils.isEmpty(airlineEstablished.trim { it <= ' ' })) {
            binding.airlineEstablished.error = "Required."
            valid = false
        } else {
            binding.airlineEstablished.error = null
        }
        return valid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}