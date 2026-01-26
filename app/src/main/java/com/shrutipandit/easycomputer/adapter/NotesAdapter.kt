package com.shrutipandit.easycomputer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.db.Question


class NotesAdapter(private val questions: List<Question>) : RecyclerView.Adapter<NotesAdapter.QuestionViewHolder>() {

        inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
            private val answerTextView: TextView = itemView.findViewById(R.id.answerTextView)

            fun bind(question: Question) {
                questionTextView.text = question.question
                answerTextView.text = question.answer

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adca_question_item, parent, false)
            return QuestionViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
            holder.bind(questions[position])
        }

        override fun getItemCount(): Int {
            return questions.size
        }
    }

