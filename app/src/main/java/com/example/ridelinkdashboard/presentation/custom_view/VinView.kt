package com.example.ridelinkdashboard.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.ridelinkdashboard.databinding.ViewVinBinding
import com.example.ridelinkdashboard.util.Constants

class VinView @JvmOverloads constructor(
        context: Context,
        private val attrs: AttributeSet? = null,
        private val defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {

    private val binding = ViewVinBinding.inflate(LayoutInflater.from(context), this, true)

    fun setValue(vin: String?) {
        if (vin == null) {
            binding.tvValueVin.text = Constants.NULL_DATA
        } else {
            binding.tvValueVin.text = vin
        }
    }
}
