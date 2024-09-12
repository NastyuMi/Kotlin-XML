package com.example.applicationwith3activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.applicationwith3activity.databinding.FragmentMiniUserProfileBinding

class MiniUserProfileFragment : Fragment() {

    private lateinit var binding: FragmentMiniUserProfileBinding
    private val arr : MiniUserProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentMiniUserProfileBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textName.text = arr.name
        binding.textAge.text = arr.age
        binding.textQuote.text = arr.quote
        binding.image.setImageResource(arr.image)
    }

}

