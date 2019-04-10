package com.hashcode.movieapp.network

import com.hashcode.movieapp.network.models.GetMoviesResponse
import com.hashcode.movieapp.network.models.GetSearchResponse
import retrofit2.Call
import retrofit2.http.GET

const val apiKey = "28ef9801379c99fb16dc16dc34bf9751"

interface MovieEndpointInterface {

    @GET("movie/popular?api_key=$apiKey")
    fun getPopularMovies(): Call<GetMoviesResponse>

    @GET("movie/top_rated?api_key=$apiKey")
    fun getTopRatedMovies(): Call<GetMoviesResponse>

    @GET("movie/upcoming?api_key=$apiKey")
    fun getUpComingMovies(): Call<GetMoviesResponse>

    @GET("search/movie?api_key=$apiKey")
    fun searchMovies(): Call<GetSearchResponse>

}