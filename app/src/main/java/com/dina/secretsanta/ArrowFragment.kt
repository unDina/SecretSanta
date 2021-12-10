package com.dina.secretsanta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArrowFragment : Fragment() {

    lateinit var giftPeopleRecyclerView: RecyclerView
    lateinit var arrowsRecyclerView: RecyclerView
    lateinit var giftedRecyclerView: RecyclerView
    lateinit var peopleNames: MutableList<String>


    fun gift(peopleNamesList: MutableList<String>) : MutableList<String> {
        val peopleNamesListShuffled = peopleNamesList.shuffled()
        val giftedNamesList: MutableList<String> = mutableListOf()
        for(people in peopleNamesList){
            var i = (peopleNamesListShuffled.indexOf(people))
            if(i < peopleNamesList.size-1) i++
            else i = 0
            giftedNamesList.add(peopleNamesListShuffled.get(i))
        }
        return giftedNamesList
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_arrow, container, false)

        peopleNames = mutableListOf("Вася", "Маша", "Дуня", "Костя", "Серёжа", "Валентина Михайловна", "Колян")
        val shafflesPeopleNames: MutableList<String> = gift(peopleNames)

        val allPeopleNames: MutableList<String> = mutableListOf()

        for(i in peopleNames.indices){
            allPeopleNames.add(peopleNames[i]+" -> "+ shafflesPeopleNames[i])
        }



        //1 recycler view
        giftPeopleRecyclerView =view.findViewById(R.id.gift_people_recycler_view)
        giftPeopleRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        giftPeopleRecyclerView.adapter = PeopleAdapter(allPeopleNames)


        return view
    }

}