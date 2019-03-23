package com.hashcode.movieapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hashcode.movieapp.R
import com.hashcode.movieapp.network.GlideApp
import com.hashcode.movieapp.network.models.Movie

class MovieAdapter(val context: Context, var allmovies: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.each_movie_layout, p0, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allmovies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = allmovies[position]
        holder.movieTextView.text = movie.originalTitle
        val imageUrl = "https://image.tmdb.org/t/p/original${movie.posterPath}"
        GlideApp.with(context)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.mipmap.popcorn)
            .into(holder.movieImageView)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImageView = itemView.findViewById<ImageView>(R.id.movieImageView)!!

        val movieTextView = itemView.findViewById<TextView>(R.id.movieTextView)!!

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