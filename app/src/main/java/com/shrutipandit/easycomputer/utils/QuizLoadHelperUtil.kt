package com.shrutipandit.easycomputer.utils

import android.content.Context
import com.shrutipandit.easycomputer.db.QuizDb
import org.json.JSONObject


object QuizLoadHelperUtil {

    fun loadQuizFromJson(context: Context, fileName: String): List<QuizDb> {
        return try {
            val jsonFile = context.assets.open(fileName)
            val jsonString = jsonFile.bufferedReader().use { it.readText() }

            val jsonObject = JSONObject(jsonString)
            val jsonArray = jsonObject.getJSONArray("results")

            val questions = mutableListOf<QuizDb>()

            for (i in 0 until jsonArray.length()) {
                val qObj = jsonArray.getJSONObject(i)

                val question = qObj.getString("question")
                val correctAnswer = qObj.getString("correct_answer")

                val incorrectAnswers = qObj.getJSONArray("incorrect_answers")
                val options = mutableListOf<String>()

                for (j in 0 until incorrectAnswers.length()) {
                    options.add(incorrectAnswers.getString(j))
                }

                options.add(correctAnswer)
                options.shuffle()

                questions.add(QuizDb(question, options, correctAnswer))
            }

            questions
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}
