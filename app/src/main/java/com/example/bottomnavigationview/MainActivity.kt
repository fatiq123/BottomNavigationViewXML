package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.fragments.FavoritesFragment
import com.example.bottomnavigationview.fragments.HomeFragment
import com.example.bottomnavigationview.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var homeFragment: HomeFragment
    private lateinit var favoritesFragment: FavoritesFragment
    private lateinit var searchFragment: SearchFragment

    val fragment = HomeFragment()
    val fragment2 = FavoritesFragment()
    val fragment3 = SearchFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_nav_view)



        bottomNavigationView.setOnItemSelectedListener {
            var fragment: Fragment? = null
            when (it.itemId) {
                R.id.miHome -> {
                    fragment = HomeFragment()
                }

                R.id.miFavorite -> {
                    fragment = FavoritesFragment()
                }

                R.id.miSearch -> {
                    fragment = SearchFragment()
                }
            }
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment!!)
                .commit()

            return@setOnItemSelectedListener true
        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_navigation_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miHome -> {
                fragment
            }

            R.id.miFavorite -> {
                fragment2
            }

            R.id.miSearch -> {
                fragment3
            }

            else -> Toast.makeText(
                this@MainActivity,
                "Please Select at-least one item",
                Toast.LENGTH_SHORT
            ).show()
        }

        return super.onOptionsItemSelected(item)
    }
}