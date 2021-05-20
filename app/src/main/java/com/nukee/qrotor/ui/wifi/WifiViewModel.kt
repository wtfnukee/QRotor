package com.nukee.qrotor.ui.wifi

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nukee.qrotor.getQrCodeBitmap
import kotlinx.android.synthetic.main.fragment_wifi.*

class WifiViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is WiFi Fragment"
    }
    val text: LiveData<String> = _text

}