package com.dina.secretsanta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PeopleFragment : Fragment() {

    lateinit var peopleRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_people, container, false)

        val peopleNames: MutableList<String> = mutableListOf("Вася", "Маша", "Дуня", "Костя", "Серёжа", "Валентина Михайловна", "Колян")

        peopleRecyclerView =view.findViewById(R.id.people_recycler_view)
        peopleRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        peopleRecyclerView.adapter = PeopleAdapter(peopleNames)

        return view
    }

}