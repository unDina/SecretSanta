package com.dina.secretsanta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationMenu: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)

        val peopleFragment = PeopleFragment()
        val arrowFragment = ArrowFragment()
        val helpFragment = HelpFragment()


        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.page_1 -> {
                    fragment = PeopleFragment()
                }
                R.id.page_2 -> {
                    fragment = ArrowFragment()
                }
                R.id.page_3 -> {
                    fragment = HelpFragment()
                }
            }
            replace_fragment(fragment!!)
            true
        }

        bottomNavigationMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.page_1

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationMenu.selectedItemId)
    }

    fun replace_fragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}