package com.shrutipandit.easycomputer.utils

import androidx.lifecycle.ViewModel

class ChNameUtil: ViewModel(){

        private lateinit var dcaChList: ArrayList<String>



    fun adcaChName(): List<String> {
        // Return the list of chapter names
        return listOf(
            "Ch-1 Computer Fundamental",
            "Ch-2 Ms.Windows",
            "Ch-3 Notepad",
            "Ch-4 WordPad",
            "Ch-5 Paint",
            "Ch-6 Ms.Office",
            "Ch-7 Ms.Word",
            "Ch-8 Ms.Excel",
            "Ch-9 Ms.Power Point",
            "Ch-10 Internet",
            "Ch-11 Publisher",
            "Ch-12 Tally",
            "Ch-13 PageMaker",
            "Ch-14 Photoshop",
            "Ch-15 Corel Drow",
            "Ch-16 Short Keys",
            "Ch-17 FullForm",
            "Ch-18 Symbol"
        )
    }


    fun dcaChName(): List<String> {
            // Return the list of chapter names
            return listOf(
                "Ch-1 Computer Fundamental",
                "Ch-2 Ms.Windows7",
                "Ch-3 Notepad",
                "Ch-4 WordPad",
                "Ch-5 Paint",
                "Ch-6 Ms-Office",
                "Ch-7 Ms.word",
                "Ch-8 Ms.Excel",
                "Ch-9 Ms.power Point",
                "Ch-10 Internet",
                "Ch-11 Publisher",
                "Ch-12 Hardware and Software"
            )
        }


        fun dtpChName(): List<String> {
            // Return the list of chapter names
            return listOf(
                "Ch-1 Computer Fundamental",
                "Ch-2 Ms.Windows7",
                "Ch-3 Notepad",
                "Ch-4 WordPad",
                "Ch-5 Paint",
                "Ch-6 Ms-Office",
                "Ch-7 Ms.word",
                "Ch-8 Ms.Excel",
                "Ch-9 Ms.power Point",
                "Ch-10 Internet",
                "Ch-11 Publisher",
                "Ch-12 Tally",
                "Ch-13 Hardware and Software"
            )
        }
    }

