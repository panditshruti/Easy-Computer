package com.shrutipandit.easycomputer.uiFragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentQuizBinding
import com.shrutipandit.easycomputer.db.QuizDb
import com.shrutipandit.easycomputer.utils.QuizLoadHelperUtil
import com.shrutipandit.easycomputer.utils.ResultDialogFragmentUtil

class QuizFragment : Fragment(R.layout.fragment_quiz) {

    private lateinit var binding: FragmentQuizBinding
    private var quizDb: List<QuizDb> = emptyList()
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuizBinding.bind(view)

        // ✅ EXACT FILE NAME
        val fileName = "quizjson.json"
        quizDb = QuizLoadHelperUtil.loadQuizFromJson(requireContext(), fileName)

        if (quizDb.isEmpty()) {
            Toast.makeText(requireContext(), "Quiz file not found!", Toast.LENGTH_LONG).show()
            return
        }

        displayQuestion()

        binding.submitButton.setOnClickListener {
            if (binding.optionsRadioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(requireContext(), "Please select an option", Toast.LENGTH_SHORT).show()
            } else {
                checkAnswer()
                currentQuestionIndex++

                if (currentQuestionIndex < quizDb.size) {
                    displayQuestion()
                } else {
                    showResultDialog()
                }
                showScore()

                binding.optionsRadioGroup.clearCheck()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayQuestion() {
        val currentQuestion = quizDb[currentQuestionIndex]
        binding.apply {
            questionTextView.text =
                "${currentQuestionIndex + 1}. ${currentQuestion.question}"
            optionARadioButton.text = currentQuestion.options[0]
            optionBRadioButton.text = currentQuestion.options[1]
            optionCRadioButton.text = currentQuestion.options[2]
            optionDRadioButton.text = currentQuestion.options[3]
        }
    }

    private fun checkAnswer() {
        val selectedId = binding.optionsRadioGroup.checkedRadioButtonId
        val selectedAnswer =
            binding.optionsRadioGroup.findViewById<RadioButton>(selectedId).text.toString()

        if (selectedAnswer == quizDb[currentQuestionIndex].correctAnswer) {
            score++
        }
    }

    private fun showResultDialog() {
        val resultDialog = ResultDialogFragmentUtil(score, quizDb.size)
        resultDialog.show(parentFragmentManager, "ResultDialog")
    }

    @SuppressLint("SetTextI18n")
    private fun showScore() {
        val scorePercentage = ((score.toDouble() / quizDb.size.toDouble()) * 100).toFloat()
        val formattedPercentage = String.format("%.1f", scorePercentage)
        binding.resultTv.text = "Your score: ${score}/${quizDb.size} (${formattedPercentage}%)"
    }



}
