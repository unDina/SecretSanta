package com.dina.secretsanta

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val peopleNameTextView: TextView = itemView.findViewById(R.id.people_name_text_view)

    fun bind(name: String){
        peopleNameTextView.text = name
    }
}