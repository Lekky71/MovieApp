package com.hashcode.movieapp.network.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetMoviesResponse : Parcelable {

    @SerializedName("page")
    @Expose
    var page: Int = 0
    @SerializedName("total_results")
    @Expose
    var totalResults: Int = 0
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int = 0
    @SerializedName("results")
    @Expose
    var results: List<Movie>? = null

    protected constructor(`in`: Parcel) {
        this.page = `in`.readValue(Int::class.javaPrimitiveType!!.classLoader) as Int
        this.totalResults = `in`.readValue(Int::class.javaPrimitiveType!!.classLoader) as Int
        this.totalPages = `in`.readValue(Int::class.javaPrimitiveType!!.classLoader) as Int
        `in`.readList(this.results, com.hashcode.movieapp.network.models.Movie::class.java!!.getClassLoader())
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param results
     * @param totalResults
     * @param page
     * @param totalPages
     */
    constructor(page: Int, totalResults: Int, totalPages: Int, results: List<Movie>) : super() {
        this.page = page
        this.totalResults = totalResults
        this.totalPages = totalPages
        this.results = results
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(page)
        dest.writeValue(totalResults)
        dest.writeValue(totalPages)
        dest.writeList(results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<GetMoviesResponse> = object : Creator<GetMoviesResponse> {


            override fun createFromParcel(`in`: Parcel): GetMoviesResponse {
                return GetMoviesResponse(`in`)
            }

            override fun newArray(size: Int): Array<GetMoviesResponse?> {
                return arrayOfNulls(size)
            }

        }
    }

}