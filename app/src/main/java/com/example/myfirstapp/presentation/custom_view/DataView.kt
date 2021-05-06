package com.example.myfirstapp.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ViewDataBinding
import java.util.*

class DataView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var binding: ViewDataBinding = ViewDataBinding.inflate(LayoutInflater.from(context), this, true)

    fun setHeader(header: String) {
        binding.tvHeaderData.text = header
    }

    fun setValue(value: Int) {
        binding.tvValue.text = value.toString()
    }

    fun setValue(value: Double) {
        binding.tvValue.text =
                resources.getString(R.string.count_data, String.format(Locale.US, "%,.2f", value))
    }

    fun setValueType(type: String) {
        binding.tvValueType.text = type
    }
}
