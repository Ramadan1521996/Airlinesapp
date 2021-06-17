package com.techzone.airlinesapp.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.techzone.airlinesapp.databinding.AddAirlineSheetBinding

class AddAirLineButtonSheet: BottomSheetDialogFragment() {
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
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}