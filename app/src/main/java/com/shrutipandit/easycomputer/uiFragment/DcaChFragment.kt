package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentDcaChBinding
import com.shrutipandit.easycomputer.utils.ChNameUtil


class DcaChFragment : Fragment(R.layout.fragment_dca_ch) {

    private lateinit var binding: FragmentDcaChBinding

    private lateinit var chNameUtil: ChNameUtil


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDcaChBinding.bind(view)

        chNameUtil = ViewModelProvider(this)[ChNameUtil::class.java]

                val chapters = chNameUtil.dcaChName()
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, chapters)
                binding.chNameListview.adapter = adapter



                binding.chNameListview.setOnItemClickListener { _, _, position, _ ->

                    val chapterName = position.plus(1)

                        val action =
                            DcaChFragmentDirections.actionDcaChFragmentToDcaNotesFragment("ch$chapterName")
                        findNavController().navigate(action)
                    }
        adapter.notifyDataSetChanged()
                }

}


