package com.shrutipandit.easycomputer.uiFragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentHomeBinding
import org.json.JSONObject
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.TimeUnit


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)


        binding.adca.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAdcaChFragment()
            findNavController().navigate(action)
        }

        binding.dca.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDcaChFragment()
            findNavController().navigate(action)
        }

        binding.dtp.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDtpChFragment()
            findNavController().navigate(action)
        }

//        binding.quese.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToPlayQuizFragment("quiz")
//            findNavController().navigate(action)
//        }
//
//
//        binding.typingCord.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToTypingFragment()
//            findNavController().navigate(action)
//        }
//
//
//        binding.videos.setOnClickListener {
//            val url = Uri.parse("https://www.youtube.com/channel/UCvjAEaYocRSJpUWE4FSVlwQ")
//            val intent = Intent(Intent.ACTION_VIEW, url)
//            startActivity(intent)
//        }
//
//        binding.shortcut.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToShortCutFragment()
//            findNavController().navigate(action)
//        }
//
//        binding.objectiveQuestion.setOnClickListener {
//            val action = HomeFragmentDirections.actionHomeFragmentToObjectiveChNameFragment(true)
//            findNavController().navigate(action)
//        }


    }


}

