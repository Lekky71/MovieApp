package com.hashcode.movieapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.hashcode.movieapp.fragments.BookmarksFragment
import com.hashcode.movieapp.fragments.HomeFragment
import com.hashcode.movieapp.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                displayFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                displayFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_bookmarks -> {
                displayFragment(BookmarksFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        displayFragment(HomeFragment())
    }

    // method to display a particular fragment
    private fun displayFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.home_container, fragment).commit()
    }
}
