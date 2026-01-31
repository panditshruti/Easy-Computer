package com.shrutipandit.easycomputer.uiFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.adapter.ShortcutKeyAdapter
import com.shrutipandit.easycomputer.databinding.FragmentShortcutKeyBinding
import com.shrutipandit.easycomputer.db.ShortcutKeyDb


class ShortcutKeyFragment : Fragment(R.layout.fragment_shortcut_key) {
private lateinit var  binding: FragmentShortcutKeyBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShortcutKeyBinding.bind(view)

                requireActivity().window.setFlags(
                    WindowManager.LayoutParams.FLAG_SECURE,
                    WindowManager.LayoutParams.FLAG_SECURE
                )


                val jsonFileString = getJsonDataFromAsset("shortcutkeyjson.json")
                val gson = Gson()
                val listShortcutType = object : TypeToken<List<ShortcutKeyDb>>() {}.type
                val shortcuts: List<ShortcutKeyDb> = gson.fromJson(jsonFileString, listShortcutType)

                // Setup RecyclerView

                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerView.adapter = ShortcutKeyAdapter(shortcuts)
            }
            private fun getJsonDataFromAsset(fileName: String): String? {
                return try {
                    val inputStream = requireContext().assets.open(fileName)
                    val size = inputStream.available()
                    val buffer = ByteArray(size)
                    inputStream.read(buffer)
                    inputStream.close()
                    String(buffer, Charsets.UTF_8)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                    null
                }
            }

        }
