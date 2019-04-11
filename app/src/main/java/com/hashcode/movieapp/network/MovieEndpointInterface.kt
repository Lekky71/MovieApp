package com.hashcode.movieapp.network

import com.hashcode.movieapp.network.models.GetMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

const val apiKey = "28ef9801379c99fb16dc16dc34bf9751"

interface MovieEndpointInterface {

    @GET("movie/popular?api_key=$apiKey")
    fun getPopularMovies(): Call<GetMoviesResponse>

    @GET("movie/top_rated?api_key=$apiKey")
    fun getTopRatedMovies(): Call<GetMoviesResponse>


}