package com.example.applicationwith3activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationwith3activity.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var avatarAdapter: AvatarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentSecondBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val avatarData = listOf(
            Pair(R.drawable.boy,"boy"),
            Pair(R.drawable.girl,"girl"),
            Pair(R.drawable.tom,"tom"),
            Pair(R.drawable.jerry,"jerry"),
            Pair(R.drawable.cat,"cat"),
            Pair(R.drawable.dog,"dog")
        )

        val save_img = R.drawable.girl

        avatarAdapter = AvatarAdapter(context, this, avatarData, { position ->
            binding.button5.text= avatarData[position].second
        })

        binding.recyclerView.adapter = avatarAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)


    }

}
