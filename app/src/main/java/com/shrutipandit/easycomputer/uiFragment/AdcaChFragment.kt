package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentAdcaChBinding

class AdcaChFragment : Fragment(R.layout.fragment_adca_ch) {
    private lateinit var binding: FragmentAdcaChBinding
    private lateinit var arrayList: ArrayList<String>
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdcaChBinding.bind(view)

                arrayList = arrayListOf(
                    "Ch-1 Computer Fundamental", "Ch-2 Ms.Windows", "Ch-3 Notepad", "Ch-4 WordPad",
                    "Ch-5 Paint", "Ch-6 Ms.Office", "Ch-7 Ms.Word", "Ch-8 Ms.Excel", "Ch-9 Ms.Power Point",
                    "Ch-10 Internet", "Ch-11 Publisher", "Ch-12 Tally", "Ch-13 PageMaker",
                    "Ch-14 Photoshop", "Ch-15 Corel Drow", "Ch-16 Short Keys", "Ch-17 FullForm", "Ch-18 Symbol"
                )

                arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, arrayList)
                binding.listviewChapterName.adapter = arrayAdapter

                binding.listviewChapterName.setOnItemClickListener { _, _, position, _ ->
                    val chapterNumber = position + 1
                    navigateToChapterOrObjective(chapterNumber)
                }



    }

private fun navigateToChapterOrObjective(chapterNumber: Int) {
    // Example logic to decide which fragment to navigate to based on chapterNumber

    navigateToChapterDetails(chapterNumber)
}

private fun navigateToChapterDetails(chapterNumber: Int) {
    val action = AdcaChFragmentDirections.actionAdcaChFragmentToAdcaNotesFragment("ch$chapterNumber")
    findNavController().navigate(action)
}



}
