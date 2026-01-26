package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentDtpChBinding


class DtpChFragment : Fragment(R.layout.fragment_dtp_ch) {
    private lateinit var binding: FragmentDtpChBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDtpChBinding.bind(view)



    }



}
