package com.example.applicationwith3activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationwith3activity.databinding.FragmentUseRecycleViewForAvatarsBinding

class UseRecycleViewForAvatarsFragment : Fragment() {

    private lateinit var binding: FragmentUseRecycleViewForAvatarsBinding
    private lateinit var avatarAdapter: AvatarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentUseRecycleViewForAvatarsBinding.inflate(layoutInflater)

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

       // val save_img = R.drawable.dog

        avatarAdapter = AvatarAdapter(context, this, avatarData) { position ->
           // binding.buttonForExamination.text = avatarData[position].second
            val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.fragmentINFO) as NavHostFragment
            val splashScreenFragment = navHostFragment.childFragmentManager.fragments[0] as OnlySplashScreenFragment
            splashScreenFragment.setFragmentResult(
                "avatar_result",
                bundleOf("img" to avatarData[position].first)
            )
        }

        binding.recyclerView.adapter = avatarAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)


    }

}
