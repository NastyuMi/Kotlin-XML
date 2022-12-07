package com.example.applicationwith3activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.navArgs
import com.example.applicationwith3activity.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private lateinit var binding: FragmentFourthBinding
    private val arr : FourthFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentFourthBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.image.setImageResource(R.drawable.dog)

        setFragmentResultListener("avatar_result"){ requestKey, bundle ->
            binding.image.setImageResource(bundle.getInt("img"))
        }

        binding.textName.text = arr.name
        binding.textAge.text = arr.age
        binding.textQuote.text = arr.quote
    }

}

