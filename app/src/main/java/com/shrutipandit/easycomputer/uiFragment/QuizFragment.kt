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
import com.shrutipandit.easycomputer.utils.QuizLoadHelperUtil.loadQuizFromJson
import com.shrutipandit.easycomputer.utils.ResultDialogFragmentUtil


class QuizFragment : Fragment(R.layout.fragment_quiz) {
    private lateinit var binding: FragmentQuizBinding


    private lateinit var quizDb: List<QuizDb>
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuizBinding.bind(view)

        val fileName = arguments?.getString("fileName")
        quizDb = loadQuizFromJson(requireContext(), fileName!!)
        displayQuestion()
        var selectedRadioButtonId: Int   // Initialize outside the click listener



        binding.apply {
            submitButton.setOnClickListener {
                selectedRadioButtonId = optionsRadioGroup.checkedRadioButtonId
                if (selectedRadioButtonId == -1) {
                    // No option selected, show a toast message or handle the case appropriately
                    Toast.makeText(requireContext(), "Please select an option", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // Option selected, proceed to check the answer
                    checkAnswer()
                    currentQuestionIndex++
                    if (currentQuestionIndex < quizDb.size) {
                        displayQuestion()
                    } else {
                        currentQuestionIndex = 0
                    }
                    showScore()
                    optionsRadioGroup.clearCheck()  // Clear the selected option after submitting
                }
            }

            // Set the listener outside the click listener
            optionsRadioGroup.setOnCheckedChangeListener { group, checkedId ->
                selectedRadioButtonId = checkedId
            }
        }


    }

    @SuppressLint("SetTextI18n")
    private fun displayQuestion() {
        val currentQuestion = quizDb[currentQuestionIndex]
        binding.apply {
            questionTextView.text = "${currentQuestionIndex.plus(1)}  ${currentQuestion.question}"
            optionARadioButton.text = currentQuestion.options[0]
            optionBRadioButton.text = currentQuestion.options[1]
            optionCRadioButton.text = currentQuestion.options[2]
            optionDRadioButton.text = currentQuestion.options[3]
        }
    }

    private fun checkAnswer() {
        val currentQuestion = quizDb[currentQuestionIndex]
        val selectedAnswer =
            binding.optionsRadioGroup.findViewById<RadioButton>(binding.optionsRadioGroup.checkedRadioButtonId).text.toString()
        if (selectedAnswer == currentQuestion.correctAnswer) {
            score++
        }
        if (currentQuestionIndex == quizDb.size - 1) {
            showResultDialog()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showScore() {
        val scorePercentage = ((score.toDouble() / quizDb.size.toDouble()) * 100).toFloat()
        val formattedPercentage = String.format("%.1f", scorePercentage)
        binding.resultTv.text = "Your score: ${score}/${quizDb.size} (${formattedPercentage}%)"
    }

    private fun showResultDialog() {
        val resultDialog = ResultDialogFragmentUtil(score, quizDb.size)
        resultDialog.show(parentFragmentManager, "ResultDialog")
    }


}
