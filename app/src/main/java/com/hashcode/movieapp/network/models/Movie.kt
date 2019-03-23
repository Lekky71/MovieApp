package com.hashcode.movieapp.network.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
class Movie : Parcelable {

    @SerializedName("vote_count")
    @Expose
    @PrimaryKey()
    var voteCount: Int = 0
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("video")
    @Expose
    var isVideo: Boolean = false
    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double = 0.toDouble()
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("popularity")
    @Expose
    var popularity: Double = 0.toDouble()
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null
    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null
    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null
    @SerializedName("genre_ids")
    @Expose
    var genreIds: List<Int>? = null
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null
    @SerializedName("adult")
    @Expose
    var isAdult: Boolean = false
    @SerializedName("overview")
    @Expose
    var overview: String? = null
    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

     constructor(`in`: Parcel) {
        this.voteCount = `in`.readValue(Int::class.javaPrimitiveType!!.classLoader) as Int
        this.id = `in`.readValue(Int::class.javaPrimitiveType!!.classLoader) as Int
        this.isVideo = `in`.readValue(Boolean::class.javaPrimitiveType!!.classLoader) as Boolean
        this.voteAverage = `in`.readValue(Double::class.javaPrimitiveType!!.classLoader) as Double
        this.title = `in`.readValue(String::class.java.classLoader) as String
        this.popularity = `in`.readValue(Double::class.javaPrimitiveType!!.classLoader) as Double
        this.posterPath = `in`.readValue(String::class.java.classLoader) as String
        this.originalLanguage = `in`.readValue(String::class.java.classLoader) as String
        this.originalTitle = `in`.readValue(String::class.java.classLoader) as String
        `in`.readList(this.genreIds, Int::class.java.classLoader)
        this.backdropPath = `in`.readValue(String::class.java.classLoader) as String
        this.isAdult = `in`.readValue(Boolean::class.javaPrimitiveType!!.classLoader) as Boolean
        this.overview = `in`.readValue(String::class.java.classLoader) as String
        this.releaseDate = `in`.readValue(String::class.java.classLoader) as String
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param genreIds
     * @param id
     * @param title
     * @param releaseDate
     * @param overview
     * @param posterPath
     * @param originalTitle
     * @param voteAverage
     * @param originalLanguage
     * @param adult
     * @param backdropPath
     * @param voteCount
     * @param video
     * @param popularity
     */
    constructor(
        voteCount: Int,
        id: Int,
        video: Boolean,
        voteAverage: Double,
        title: String,
        popularity: Double,
        posterPath: String,
        originalLanguage: String,
        originalTitle: String,
        genreIds: List<Int>,
        backdropPath: String,
        adult: Boolean,
        overview: String,
        releaseDate: String
    ) : super() {
        this.voteCount = voteCount
        this.id = id
        this.isVideo = video
        this.voteAverage = voteAverage
        this.title = title
        this.popularity = popularity
        this.posterPath = posterPath
        this.originalLanguage = originalLanguage
        this.originalTitle = originalTitle
        this.genreIds = genreIds
        this.backdropPath = backdropPath
        this.isAdult = adult
        this.overview = overview
        this.releaseDate = releaseDate
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(voteCount)
        dest.writeValue(id)
        dest.writeValue(isVideo)
        dest.writeValue(voteAverage)
        dest.writeValue(title)
        dest.writeValue(popularity)
        dest.writeValue(posterPath)
        dest.writeValue(originalLanguage)
        dest.writeValue(originalTitle)
        dest.writeList(genreIds)
        dest.writeValue(backdropPath)
        dest.writeValue(isAdult)
        dest.writeValue(overview)
        dest.writeValue(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Movie> = object : Creator<Movie> {


            override fun createFromParcel(`in`: Parcel): Movie {
                return Movie(`in`)
            }

            override fun newArray(size: Int): Array<Movie?> {
                return arrayOfNulls(size)
            }

        }
    }

}