//package com.hashcode.movieapp.data
//
//import android.app.Application
//import android.arch.lifecycle.AndroidViewModel
//import android.arch.lifecycle.LiveData
//import android.arch.lifecycle.MutableLiveData
//import com.hashcode.movieapp.network.data.BookMarkData
//
//class BookMarkViewModel(application: Application) : AndroidViewModel(application) {
//    private val movieDao: MovieDataDao = BookMarkDatabase.getInstance(application)!!.todoDataDao()
//
//    fun insertMovieIntoDb(movie: BookMarkData): LiveData<Boolean> {
//        val response = MutableLiveData<Boolean>()
//        movieDao.insertMovie(movie)
//        response.postValue(true)
//        return response
//    }
//
//    fun deleteMovieFromDb(movie: BookMarkData): LiveData<Boolean> {
//        val response = MutableLiveData<Boolean>()
//        movieDao.deleteMovie(movie)
//        response.postValue(true)
//        return response
//    }
//
//    fun getAllMovieFav(): LiveData<ArrayList<BookMarkData>> {
//        val response = MutableLiveData<ArrayList<BookMarkData>>()
//        val data = movieDao.getAllMovies()
//        response.postValue(data as ArrayList<BookMarkData>?)
//        return response
//    }
//
//}