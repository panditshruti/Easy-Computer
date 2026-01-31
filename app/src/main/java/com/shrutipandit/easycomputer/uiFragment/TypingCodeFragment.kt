package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentTypingCodeBinding


class TypingCodeFragment : Fragment(R.layout.fragment_typing_code) {
private lateinit var binding: FragmentTypingCodeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTypingCodeBinding.bind(view)


        
        
    }

}
