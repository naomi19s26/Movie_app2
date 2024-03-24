package com.example.movie_app2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


const val MOVIE_EXTRA = "MOVIE_EXTRA"
class MovieAdapter(private val context: Context, private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }


    override fun getItemCount() = movies.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.image)

        init {
            itemView.setOnClickListener(this)

        }
        fun bind(movie: Movie){
            title.text = movie.title


            Glide.with(context).load(movie.posterImageURL).into(ivPoster)

        }

        override fun onClick(v: View?) {
            val movie = movies[adapterPosition]
            Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()

            val intent = Intent(context, DetailActivity::class.java)

            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)
        }


    }

}
