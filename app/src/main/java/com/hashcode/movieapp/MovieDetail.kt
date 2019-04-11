package com.hashcode.movieapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hashcode.movieapp.network.GlideApp
import com.hashcode.movieapp.network.models.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.content_movie_detail2.*
import kotlinx.android.synthetic.main.content_movie_detail2.view.*

class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)

        val muvi : Movie
        muvi = intent.getParcelableExtra("data")
        val rtoolbar = findViewById(R.id.toolbar_layout) as CollapsingToolbarLayout
        rtoolbar.setTitle(muvi.title)
        aboutMovie.text = muvi.overview
       Movietitle.text = muvi.title
        Date.text = muvi.releaseDate
        language.text = muvi.originalLanguage

        val imageUrl = "https://image.tmdb.org/t/p/original${muvi.backdropPath}"
        GlideApp.with(this)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(MovieDetailImage)








    }
}
