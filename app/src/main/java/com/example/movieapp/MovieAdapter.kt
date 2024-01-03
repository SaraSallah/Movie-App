package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ItemMovieBinding
import com.example.movieapp.model.data.Movie

 class MovieAdapter(private var items : List<Movie> ,private val listener : MovieInteractionListener)
    :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).
        inflate(R.layout.item_movie,parent,false))

    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.item = currentItem
        holder.binding.listener =listener
        // before data binding

//        holder.binding.apply {
//            textMovieTitle.text = currentItem.originalTitle
//            textMovieRate.text = currentItem.voteAverage.toString()
//            textMovieTitle.setOnClickListener {
//                listener.onClickMovie(currentItem)
//            }
//            Glide.with(imagePoster).load(currentItem.posterPath).centerCrop().into(imagePoster)
//
//        }

    }
     fun setItems(newList :  List<Movie>){
         items = newList

     }
    class MovieViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val binding = ItemMovieBinding.bind(itemView)

    }

}
interface MovieInteractionListener{
    fun onClickMovie(movie: Movie)
}