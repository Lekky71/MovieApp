package com.hashcode.movieapp.fragments

import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import android.widget.Toast
import com.hashcode.movieapp.R
import com.hashcode.movieapp.adapters.MovieAdapter
import com.hashcode.movieapp.models.MovieType
import com.hashcode.movieapp.models.MovieViewModel
import com.hashcode.movieapp.network.NetworkUtils
import com.hashcode.movieapp.network.models.Movie


class HomeFragment : Fragment() {

    private var allMovies = ArrayList<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_layout, container, false)

        val moviesRecyclerView = view.findViewById<RecyclerView>(R.id.allMoviesRecyclerView)
        val movieSpinner = view.findViewById<Spinner>(R.id.movieSpinner)

        val layoutManager = GridLayoutManager(context, 2)
        val movieAdapter = MovieAdapter(context!!, allMovies)

        moviesRecyclerView.adapter = movieAdapter
        moviesRecyclerView.layoutManager = layoutManager

        val movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        fun fetchMovies(movieType: MovieType) {
            if (NetworkUtils.isOnline(context!!)) {
                val progressDialog = ProgressDialog(context!!)
                progressDialog.setTitle("Fetch Movies")
                progressDialog.setMessage("Retrieving movies...")
                progressDialog.show()
                movieViewModel.getAllMovies(movieType).observe(this, Observer { movies ->
                    progressDialog.dismiss()
                    if (movies != null) {
                        allMovies = movies
                        movieAdapter.swapMovies(allMovies)
                    } else {
                        Toast.makeText(context, "An error occurred", Toast.LENGTH_LONG).show()
                    }
                })
            } else {
                Toast.makeText(context, "no network", Toast.LENGTH_LONG).show()
            }
        }


        movieSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when(position){
                    0 -> fetchMovies(MovieType.POPULAR)
                    1 -> fetchMovies(MovieType.TOP_RATED)
                    2 -> fetchMovies(MovieType.UPCOMING)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }



        return view
    }


}
