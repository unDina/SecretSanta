package com.dina.secretsanta

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter(private val peopleNames: MutableList<String>) :
    RecyclerView.Adapter<PeopleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.people_list_item, parent, false)
        return PeopleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val name = peopleNames[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return peopleNames.size
    }

}
