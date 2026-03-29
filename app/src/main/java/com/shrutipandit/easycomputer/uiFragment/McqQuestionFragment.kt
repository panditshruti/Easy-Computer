package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.adapter.NotesAdapter
import com.shrutipandit.easycomputer.databinding.FragmentMcqQuestionBinding
import com.shrutipandit.easycomputer.utils.QuestionUtil


class McqQuestionFragment : Fragment(R.layout.fragment_mcq_question) {

private lateinit var binding: FragmentMcqQuestionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMcqQuestionBinding.bind(view)



        val chapterName = arguments?.getString("chapterName")
        val questionList =
            QuestionUtil.readQuestionsFromJson(requireContext(), "mcq_qestionjson.json", chapterName!!)

        binding.objectiveRecyclerView
        val adapter = NotesAdapter(questionList)
        binding.objectiveRecyclerView.adapter = adapter
        binding.objectiveRecyclerView.layoutManager = LinearLayoutManager(requireContext())






    }
}