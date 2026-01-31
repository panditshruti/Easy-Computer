package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentAdcaChBinding
import com.shrutipandit.easycomputer.utils.ChNameUtil

class AdcaChFragment : Fragment(R.layout.fragment_adca_ch) {
    private lateinit var binding: FragmentAdcaChBinding
    private lateinit var chNameUtil: ChNameUtil


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdcaChBinding.bind(view)


        chNameUtil = ViewModelProvider(this)[ChNameUtil::class.java]

        val chapters = chNameUtil.adcaChName()
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, chapters)
        binding.listviewChapterName.adapter = adapter

        binding.listviewChapterName.setOnItemClickListener { _, _, position, _ ->

            val chapterName = position.plus(1)

            val action =
                AdcaChFragmentDirections.actionAdcaChFragmentToAdcaNotesFragment("ch$chapterName")
            findNavController().navigate(action)
        }
        adapter.notifyDataSetChanged()
    }

}