package com.example.myfirstapp.presentation.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.myfirstapp.R

abstract class BaseActivity : AppCompatActivity() {
    protected abstract val binding: ViewBinding

    protected abstract fun iniView()

    private lateinit var progressDialog: Dialog
    open val viewModel: BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        progressDialog()
        bindViewModel()
        iniView()
    }

    private fun bindViewModel() {
        viewModel?.isInProgress?.observe(this, { isInProgress ->
            if (isInProgress) {
                progressDialog.show()
            } else {
                progressDialog.dismiss()
            }
        })
    }

    private fun progressDialog() {
        progressDialog = Dialog(this)
        val inflate = LayoutInflater.from(this).inflate(R.layout.layout_progress, null)
        progressDialog.setContentView(inflate)
        progressDialog.setCancelable(false)
        progressDialog.window?.setBackgroundDrawable(
                ColorDrawable(Color.TRANSPARENT)
        )
    }
}
