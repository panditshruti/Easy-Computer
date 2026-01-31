package com.shrutipandit.easycomputer.utils

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.shrutipandit.easycomputer.R


class ResultDialogFragmentUtil(private val score: Int, private val totalQuestions: Int) : DialogFragment() {


        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val scorePercentage = ((score.toDouble() / totalQuestions.toDouble()) * 100).toFloat()
            val formattedPercentage = String.format("%.1f", scorePercentage)

            val message = "Your score: $score/$totalQuestions (${formattedPercentage}%)"

            return activity?.let {
                val builder = AlertDialog.Builder(it)
                builder.setTitle("Quiz Result")
                    .setMessage(message)
                    .setPositiveButton("Ok") { dialog, _ ->
                        // Dismiss the dialog when Ok button is clicked
                        dialog.dismiss()
                    }
                builder.create()
            } ?: throw IllegalStateException("Activity cannot be null")
        }
    }

