package com.example.movie_app2

import android.content.ContentValues
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import android.content.Intent
import android.widget.ImageView
import com.bumptech.glide.Glide
import android.content.Context




class DetailActivity : AppCompatActivity() {

    private lateinit var TVImage: ImageView
    private lateinit  var TVTitle: TextView
    private lateinit var TVOverview: TextView
    private lateinit var ratingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        TVImage = findViewById(R.id.image2)
        TVTitle = findViewById(R.id.TVTitle)
        TVOverview = findViewById(R.id.TVOverview)
        ratingBar = findViewById(R.id.ratingBar)

        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie

        Log.i(ContentValues.TAG, "move is $movie")

        Glide.with(this).load(movie.dropImageURL).into(TVImage)

        TVTitle.text = movie.title
        TVOverview.text = movie.overview
        ratingBar.rating = movie.voteAverage?.toFloat() ?: 0f
    }
}