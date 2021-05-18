package com.nukee.qrotor.ui.wifi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nukee.qrotor.R
import com.nukee.qrotor.databinding.FragmentWifiBinding
import com.nukee.qrotor.getQrCodeBitmap
import kotlinx.android.synthetic.main.fragment_wifi.*


class WifiFragment : Fragment() {

    private lateinit var wifiViewModel: WifiViewModel
    private var _binding: FragmentWifiBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        wifiViewModel =
            ViewModelProvider(this).get(WifiViewModel::class.java)

        _binding = FragmentWifiBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textWifi
        wifiViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val generateButton: Button = binding.generateBtn
        generateButton.setOnClickListener(){
            qrCodeImage.setImageBitmap(getQrCodeBitmap("f"))
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}