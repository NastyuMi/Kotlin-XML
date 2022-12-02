package com.example.applicationwith3activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.applicationwith3activity.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentFirstBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener(){
           // binding.button.text="нажалась"
            val action = FirstFragmentDirections.actionFirstFragmentToMainActivity()
            findNavController().navigate(action)
        }

        binding.buttonNO.setOnClickListener {
            binding.root.alpha = 0F
        }
    }

}
