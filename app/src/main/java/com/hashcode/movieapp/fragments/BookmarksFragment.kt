package com.hashcode.movieapp.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import com.hashcode.movieapp.R
import com.hashcode.movieapp.adapters.MovieAdapter
import com.hashcode.movieapp.models.MovieViewModel
import com.hashcode.movieapp.network.models.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.each_movie_layout.*

class BookmarksFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_bookmarks_layout, container, false)


        return view
    }

}
