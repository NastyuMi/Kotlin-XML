package com.example.applicationwith3activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.applicationwith3activity.databinding.FragmentOnlySplashScreenBinding

class OnlySplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentOnlySplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentOnlySplashScreenBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var name : String? = ""

        var age : String? = ""

        var quote : String? = ""

        childFragmentManager.setFragmentResultListener("main_data",this){ _, bundle ->

            name = bundle.getString("name")
            age = bundle.getString("age")
            quote = bundle.getString("quote")
        }

        binding.root.setOnClickListener {
            if (name == "" ){

                binding.textInformationalAboutUser.text = binding.textInformationalAboutUser.text

            }
            else{

                setFragmentResultListener("avatar_result") { requestKey, bundle ->
                    val image =  bundle.getInt("img", 45)
                    findNavController().navigate(
                        OnlySplashScreenFragmentDirections.actionOnlySplashScreenFragmentToMiniUserProfileFragment(
                            name.toString(),
                            age.toString(),
                            quote.toString(),
                            image
                        )
                    )
                }
            }

        }






    }

}
