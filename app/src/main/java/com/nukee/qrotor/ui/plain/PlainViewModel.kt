package com.nukee.qrotor.ui.plain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlainViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Plain Fragment"
    }
    val text: LiveData<String> = _text
}
