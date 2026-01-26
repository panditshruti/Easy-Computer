package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentHelpCenterBinding
import com.shrutipandit.easycomputer.databinding.FragmentHomeBinding


class HelpCenterFragment : Fragment(R.layout.fragment_help_center) {

    private var _binding: FragmentHelpCenterBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHelpCenterBinding.bind(view)

    }

    }
