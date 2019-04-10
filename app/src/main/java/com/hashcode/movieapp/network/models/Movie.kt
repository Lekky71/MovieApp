package com.hashcode.movieapp.network.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
class Movie() : Parcelable {

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

    constructor(parcel: Parcel) : this() {
        voteCount = parcel.readInt()
        id = parcel.readInt()
        isVideo = parcel.readByte() != 0.toByte()
        voteAverage = parcel.readDouble()
        title = parcel.readString()
        popularity = parcel.readDouble()
        posterPath = parcel.readString()
        originalLanguage = parcel.readString()
        originalTitle = parcel.readString()
        backdropPath = parcel.readString()
        isAdult = parcel.readByte() != 0.toByte()
        overview = parcel.readString()
        releaseDate = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(voteCount)
        parcel.writeInt(id)
        parcel.writeByte(if (isVideo) 1 else 0)
        parcel.writeDouble(voteAverage)
        parcel.writeString(title)
        parcel.writeDouble(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(backdropPath)
        parcel.writeByte(if (isAdult) 1 else 0)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }


}