package com.nukee.qrotor.ui.plain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nukee.qrotor.R
import com.nukee.qrotor.databinding.FragmentPlainBinding
import com.nukee.qrotor.getQrCodeBitmap
import kotlinx.android.synthetic.main.fragment_plain.*
import kotlinx.android.synthetic.main.fragment_wifi.*

class PlainFragment : Fragment() {

    private lateinit var plainViewModel: PlainViewModel
    private var _binding: FragmentPlainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        plainViewModel =
            ViewModelProvider(this).get(PlainViewModel::class.java)

        _binding = FragmentPlainBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPlain
        plainViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val text_Input: EditText = binding.TextInput
        val generateButton: Button = binding.generateBtnPlain

        lateinit var text: String
        if (text_Input.text.isBlank()) {
            text_Input.setHintTextColor(resources.getColor(R.color.red))
        } else {
            text = text_Input.text.toString()
            text_Input.setHintTextColor(resources.getColor(R.color.gray))
        }

        generateButton.setOnClickListener {
           println(text_Input.text)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
