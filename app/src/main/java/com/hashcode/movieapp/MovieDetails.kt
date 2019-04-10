package com.hashcode.movieapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.content_movie_details.*
import android.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hashcode.movieapp.network.GlideApp
import com.hashcode.movieapp.network.models.Movie
import kotlinx.android.synthetic.main.content_movie_details.view.*


class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setSupportActionBar(movieTitleBar)

        val movies : Movie
        movies = intent.getParcelableExtra("data")

    if(movies != null){
        Log.i("Yes it worked", "Working")
        val collapsingToolbar = findViewById(R.id.movieImageBarView) as CollapsingToolbarLayout
        collapsingToolbar.setTitle(movies.title)

        val movieImage = findViewById(R.id.movieImage) as ImageView
        val imageUrlOne = "https://image.tmdb.org/t/p/original${movies.backdropPath}"
        val imageUrlTwo = "https://image.tmdb.org/t/p/original${movies.posterPath}"
        GlideApp.with(this)
            .load(imageUrlOne)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(movieImage)

        GlideApp.with(this)
            .load(imageUrlTwo)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(movieDp)

        movieName.text = movies.title
        language.text = movies.originalLanguage

        val rating: Int = (movies.voteCount)
        val cal = 5 * rating / 10

        ratingBar.rating = cal.toFloat()

        aboutMovie.text = movies.overview
        date.text = movies.releaseDate
    }




    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item!!.itemId == android.R.id.home) {
            finish()
            true
        } else {

            super.onOptionsItemSelected(item)
        }


    }


}
