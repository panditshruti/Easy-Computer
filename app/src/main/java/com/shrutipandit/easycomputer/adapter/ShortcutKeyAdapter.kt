package com.shrutipandit.easycomputer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.db.ShortcutKeyDb

class ShortcutKeyAdapter (private val shortcutKey: List<ShortcutKeyDb>): RecyclerView.Adapter<ShortcutKeyAdapter.ShortcutViewHolder>(){


        class ShortcutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val shortcutTextView: TextView = itemView.findViewById(R.id.shortcutTextView)
            val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortcutViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_shortcutkey, parent, false)
            return ShortcutViewHolder(view)
        }

        override fun onBindViewHolder(holder: ShortcutViewHolder, position: Int) {
            val shortcut = shortcutKey[position]
            holder.shortcutTextView.text = shortcut.shortcut
            holder.descriptionTextView.text = shortcut.description
        }
        override fun getItemCount() = shortcutKey.size

}