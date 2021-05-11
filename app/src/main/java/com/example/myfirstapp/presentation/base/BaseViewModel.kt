package com.example.myfirstapp.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

abstract class BaseViewModel : ViewModel() {

    val message: MutableLiveData<BaseMessage> = SingleLiveEvent()
    val isInProgress = MutableLiveData<Boolean>()

    fun postMessage(message: String?, type: Int = BaseMessage.Type.SHORT) {
        this.message.postValue(
                BaseMessage(
                        message = message,
                        type = type
                )
        )
    }

    fun postMessage(message: Int?, type: Int = BaseMessage.Type.SHORT) {
        this.message.postValue(
                BaseMessage(
                        messageId = message,
                        type = type
                )
        )
    }

    class BaseMessage internal constructor(
            val message: String? = null,
            val messageId: Int? = null,
            val type: Int = Type.SHORT
    ) {
        class Type {
            companion object {
                const val LONG = Snackbar.LENGTH_LONG
                const val SHORT = Snackbar.LENGTH_SHORT
                const val INSTANT = Snackbar.LENGTH_INDEFINITE
            }
        }
    }

}
