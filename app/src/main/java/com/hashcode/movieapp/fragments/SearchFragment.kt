package com.hashcode.movieapp.fragments

import android.app.SearchManager
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.parseUri
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hashcode.movieapp.R
import com.hashcode.movieapp.adapters.MovieAdapter
import com.hashcode.movieapp.models.MovieViewModel
import com.hashcode.movieapp.network.models.Movie


class SearchFragment : Fragment() {

    private var allMovies = ArrayList<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_search_layout, container, false)
        val moviesRecyclerView = view.findViewById<RecyclerView>(R.id.searchMoviesRecyclerView)

        val layoutManager = GridLayoutManager(context, 2)
        val movieAdapter = MovieAdapter(context!!, allMovies)

        moviesRecyclerView.adapter = movieAdapter
        moviesRecyclerView.layoutManager = layoutManager


        val movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)



        return view

    }



}
