package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.adapter.NotesAdapter
import com.shrutipandit.easycomputer.databinding.FragmentDcaNotesBinding
import com.shrutipandit.easycomputer.utils.QuestionUtil


class DcaNotesFragment : Fragment(R.layout.fragment_dca_notes) {
    private lateinit var binding: FragmentDcaNotesBinding
    private val args: DcaNotesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDcaNotesBinding.bind(view)

        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        // ✅ THIS WILL NEVER BE NULL
        val chapterName = args.chapterName

        // ✅ JSON LOAD
        val questionList = QuestionUtil.readQuestionsFromJson(requireContext(),"questionjson.json",chapterName)

        // ✅ RecyclerView setup
        val adapter = NotesAdapter(questionList)
        binding.notesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notesRecyclerView.adapter = adapter
    }
}