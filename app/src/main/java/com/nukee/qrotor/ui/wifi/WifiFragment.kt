package com.nukee.qrotor.ui.wifi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nukee.qrotor.R
import com.nukee.qrotor.databinding.FragmentWifiBinding
import com.nukee.qrotor.getQrCodeBitmap
import com.nukee.qrotor.getWifiCode
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
        wifiViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

        //View bindings
        val SSID_Input: EditText = binding.SSIDInput
        val AuthTypeRadio: RadioGroup = binding.AuthTypeRadio
        val Password_Input = binding.PasswordInput
        val generateButton: Button = binding.generateBtn

        generateButton.setOnClickListener(){
            val ssid: String = SSID_Input.text.toString()

            //If auth_type was not selected, then set nopass
            val AuthTypeSelectedOption = AuthTypeRadio.checkedRadioButtonId
            lateinit var auth_type: String
            lateinit var password: String
            if (AuthTypeSelectedOption==-1) {
                auth_type = "nopass"
                password = "nopass"
            } else {
                auth_type = resources.getResourceEntryName(AuthTypeSelectedOption)
                password = Password_Input.text.toString()
            }

            //TODO: do SSID check

            qrCodeImage.setImageBitmap(getQrCodeBitmap(getWifiCode(
                ssid = ssid,
                auth_type = auth_type,
                password = password,
                hidden = false,
            )))
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}