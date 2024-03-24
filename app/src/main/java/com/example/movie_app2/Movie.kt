package com.example.movie_app2

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel

import org.json.JSONArray
import kotlinx.parcelize.Parcelize
import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//gets information we need from the API
@Keep
@Serializable
data class Movie(
    @SerialName("id")
    val movieId: Int?,

    @SerialName("poster_path")
    private val posterPath: String?,

    @SerialName("backdrop_path")
    private val backdropPath: String?,

    @SerialName("vote_average")
    val voteAverage: Double?,

    @SerialName("title")
    val title: String?,

    @SerialName("overview")
    val overview: String
): java.io.Serializable {
    val posterImageURL: String
        get() = "https://image.tmdb.org/t/p/w500/$posterPath"
    val dropImageURL: String
        get() = "https://image.tmdb.org/t/p/w500/$backdropPath"

    companion object {
        fun fromJsonArray(movieJSONArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJSONArray.length()) {
                val movieJson = movieJSONArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("backdrop_path"),
                        movieJson.getDouble("vote_average"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}
