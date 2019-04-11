package com.hashcode.movieapp

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hashcode.movieapp.network.GlideApp
import com.hashcode.movieapp.network.models.Movie
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.content_movie_details.*

class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setSupportActionBar(toolbar)

        val movie : Movie = intent.getParcelableExtra("data")

        val toolbar = findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        toolbar.title = movie.title

        //using glideApp to load the image from an API
        val imageUrl = "https://image.tmdb.org/t/p/original${movie.posterPath}"
        GlideApp.with(this)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(moviePic)

        //using glideApp to load the image from an API
        val imageUrl1 = "https://image.tmdb.org/t/p/original${movie.backdropPath}"
        GlideApp.with(this)
            .load(imageUrl1)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(movie_image)

        aboutMovie.text = movie.overview
        header.text = movie.title
        date.text = movie.releaseDate


    }
}
