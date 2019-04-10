package com.hashcode.movieapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hashcode.movieapp.MovieDetails
import com.hashcode.movieapp.network.GlideApp
import com.hashcode.movieapp.network.models.Movie
import kotlinx.android.synthetic.main.each_movie_layout.view.*
import android.os.Bundle
import android.R
import android.arch.persistence.room.Insert


class MovieAdapter(val context: Context, var allmovies: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(com.hashcode.movieapp.R.layout.each_movie_layout, p0, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allmovies.size
    }



    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = allmovies[position]
        holder.itemView.movieTextView.text = movie.originalTitle
        val imageUrl = "https://image.tmdb.org/t/p/original${movie.posterPath}"
        GlideApp.with(context)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(com.hashcode.movieapp.R.mipmap.popcorn)
            .into(holder.itemView.movieImageView)

        holder.itemView.setOnClickListener {
            val details: Movie = allmovies[position]

            val intent = Intent(context, MovieDetails::class.java)
            intent.putExtra("data", details)
            context.startActivity(intent)
        }

        fun isBookMark() {
            holder.itemView.bookmark.setImageResource(com.hashcode.movieapp.R.drawable.ic_bookmark_black_24dp)

        }

        fun isNotBookMark(){
            holder.itemView.bookmark.setImageResource(com.hashcode.movieapp.R.drawable.ic_bookmark_border_black_24dp)

        }

        holder.itemView.bookmark.setOnClickListener{
            isBookMark()
        }

    }



    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

        }

    }


    fun swapMovies(movies: ArrayList<Movie>?){
        if(movies == null){
            allmovies = ArrayList()
        }
        else{
            allmovies = movies
            notifyDataSetChanged()
        }
    }


}



