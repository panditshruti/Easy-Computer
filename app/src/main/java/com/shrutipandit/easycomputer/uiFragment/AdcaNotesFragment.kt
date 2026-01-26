package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.adapter.NotesAdapter
import com.shrutipandit.easycomputer.databinding.FragmentAdcaNotesBinding
import com.shrutipandit.easycomputer.utils.QuestionUtil


class AdcaNotesFragment : Fragment(R.layout.fragment_adca_notes) {
private lateinit var binding: FragmentAdcaNotesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdcaNotesBinding.bind(view)


        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        val chapterName = arguments?.getString("chapterName")
        val questionList =
            QuestionUtil.readQuestionsFromJson(requireContext(), "questionjson.json", chapterName)

        val adapter = NotesAdapter(questionList)
        binding.notesRecyclerView.adapter = adapter
        binding.notesRecyclerView.layoutManager = LinearLayoutManager(requireContext())



    }

        }


