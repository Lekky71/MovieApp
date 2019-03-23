package com.hashcode.movieapp.models

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.hashcode.movieapp.network.MovieEndpointInterface
import com.hashcode.movieapp.network.RetrofitBuilder
import com.hashcode.movieapp.network.models.GetMoviesResponse
import com.hashcode.movieapp.network.models.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class MovieType {
    POPULAR,
    TOP_RATED
}
class MovieViewModel(application: Application): AndroidViewModel(application) {

    val TAG = MovieViewModel::class.java.simpleName

    fun getAllMovies(type: MovieType): LiveData<ArrayList<Movie>> {
        val result = MutableLiveData<ArrayList<Movie>>()
        val retrofit = RetrofitBuilder.getRetrofit()
        val apiEndpoint = retrofit.create(MovieEndpointInterface::class.java)

        val call = when(type) {
            MovieType.POPULAR -> {
                apiEndpoint.getPopularMovies()
            }
            MovieType.TOP_RATED -> {
                apiEndpoint.getTopRatedMovies()
            }
        }

        call.enqueue(object : Callback<GetMoviesResponse> {
            override fun onResponse(call: Call<GetMoviesResponse>, response: Response<GetMoviesResponse>) {
                if(response.body() == null){
                    result.postValue(null)
                    Log.i(TAG, "movie size is on failure")
                }
                else{
                    result.postValue(response.body()!!.results as ArrayList<Movie>)
                    Log.i(TAG, "movie size is ${response.body()!!.results!!.size}")
                }
            }

            override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                result.postValue(null)
            }
        })

        return result
    }
}