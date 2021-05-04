package com.example.myfirstapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.myfirstapp.databinding.ViewDataBinding
import java.util.*

class DataView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var binding: ViewDataBinding = ViewDataBinding.inflate(LayoutInflater.from(context), this, true)

    fun setHeadingData(heading: String) {
      binding.tvHeadingData.text = heading
    }

    fun setCountLongData(count: Long) {
      binding.tvCountData.text = count.toString()
    }

    fun setCountDoubleData(count: Double) {
       binding.tvCountData.text =
                resources.getString(R.string.count_data, String.format(Locale.US, "%,.2f", count))
    }

    fun setTextData(text: String) {
       binding.tvTextData.text = text
    }
}
