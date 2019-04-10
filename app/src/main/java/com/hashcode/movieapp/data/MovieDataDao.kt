//package com.hashcode.movieapp.data
//
//import android.arch.persistence.room.*
//import com.hashcode.movieapp.network.data.BookMarkData
//import com.hashcode.movieapp.network.models.Movie
//
//
//interface MovieDataDao {
//    @Query("SELECT * FROM bookmark")
//    fun getAllMovies(): List<BookMarkData>
//
//    @Query("SELECT * FROM bookmark where id=:movieId")
//    fun getMoviesById(movieId: String): Movie
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertMovie(movie: BookMarkData)
//
//    @Delete
//    fun deleteMovie(movie: BookMarkData)
//}