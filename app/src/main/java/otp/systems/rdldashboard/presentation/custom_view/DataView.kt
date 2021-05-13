package otp.systems.rdldashboard.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import otp.systems.rdldashboard.R
import otp.systems.rdldashboard.databinding.ViewDataBinding
import otp.systems.rdldashboard.util.Constants
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

    fun setValue(value: Int?) {
        if (value == null){
            binding.tvValue.text = Constants.NULL_DATA
        } else {
            binding.tvValue.text = value.toString()
        }
    }

    fun setValue(value: Double?) {
        if (value == null) {
            binding.tvValue.text = Constants.NULL_DATA
        } else {
            binding.tvValue.text =
                    resources.getString(R.string.count_data, String.format(Locale.US, "%,.1f", value))
        }
    }

    fun setValueType(type: String) {
        binding.tvValueType.text = type
    }
}
