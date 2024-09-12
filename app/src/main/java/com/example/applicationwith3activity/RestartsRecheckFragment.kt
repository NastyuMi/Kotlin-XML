package com.example.applicationwith3activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.applicationwith3activity.databinding.FragmentRestartsRecheckBinding

class RestartsRecheckFragment : Fragment() {

    private lateinit var binding: FragmentRestartsRecheckBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentRestartsRecheckBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonYES.setOnClickListener(){
           // binding.button.text="нажалась"
            val action = RestartsRecheckFragmentDirections.actionRestartsRecheckFragmentToMainActivity()
            findNavController().navigate(action)
        }

        binding.buttonNO.setOnClickListener {
            val action = RestartsRecheckFragmentDirections.actionRestartsRecheckFragmentToRestartOrNextActivity()
            findNavController().navigate(action)
        }
    }

}
