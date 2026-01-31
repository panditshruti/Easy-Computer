package com.shrutipandit.easycomputer.utils

import android.content.Context
import com.shrutipandit.easycomputer.db.QuizDb
import org.json.JSONObject
import java.io.InputStream

object QuizLoadHelperUtil {

        fun loadQuizFromJson(context: Context,fileName:String): List<QuizDb> {
            val jsonFile: InputStream = context.assets.open("$fileName quizjson.json")
            val jsonString = jsonFile.bufferedReader().use { it.readText() }
            val jsonObject = JSONObject(jsonString)
            val jsonArray = jsonObject.getJSONArray("results")

            val questions = mutableListOf<QuizDb>()

            for (i in 0 until jsonArray.length()) {
                val questionObject = jsonArray.getJSONObject(i)
                val question = questionObject.getString("question")
                val correctAnswer = questionObject.getString("correct_answer")
                val incorrectAnswers = questionObject.getJSONArray("incorrect_answers")
                val options = mutableListOf<String>()
                for (j in 0 until incorrectAnswers.length()) {
                    options.add(incorrectAnswers.getString(j))
                }
                options.add(correctAnswer)
                options.shuffle()
                questions.add(QuizDb(question, options, correctAnswer))
            }

            return questions
        }
    }

