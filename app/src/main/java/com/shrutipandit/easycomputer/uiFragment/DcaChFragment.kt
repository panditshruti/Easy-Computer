package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentDcaChBinding


class DcaChFragment : Fragment(R.layout.fragment_dca_ch) {

    private lateinit var binding: FragmentDcaChBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDcaChBinding.bind(view)



    }



}
