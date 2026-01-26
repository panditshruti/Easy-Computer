package com.shrutipandit.easycomputer.utils

import android.content.Context
import android.util.Log
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.shrutipandit.easycomputer.db.Question

object QuestionUtil {

    fun readQuestionsFromJson(
        context: Context,
        fileName: String,
        chapterName: String?
    ): List<Question> {

        val list = mutableListOf<Question>()

        try {
            val jsonString = context.assets.open(fileName)
                .bufferedReader().use { it.readText() }

            val gson = Gson()
            val type = object : TypeToken<Map<String, Map<String, Question>>>() {}.type
            val chapterMap: Map<String, Map<String, Question>> =
                gson.fromJson(jsonString, type)

            Log.d("JSON_TEST", "Requested chapter = $chapterName")
            Log.d("JSON_TEST", "Available chapters = ${chapterMap.keys}")

            chapterMap[chapterName]?.values?.let {
                list.addAll(it)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return list
    }



}

