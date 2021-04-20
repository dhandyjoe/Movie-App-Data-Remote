package com.example.movieappapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.movieappapi.data.remote.DataMovie
import com.example.movieappapi.databinding.ItemMovieHompageBinding

class MovieAdapter : PagingDataAdapter<DataMovie, MovieAdapter.MovieViewHolder>(COMPARATOR) {

    class MovieViewHolder(private val binding: ItemMovieHompageBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: DataMovie) {
            Glide.with(itemView)
                    .load("${movie.baseUrlImage}${movie.poster_path}")
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(binding.ivMoviePoster)

            binding.tvOriginalTitle.text = movie.original_title
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieHompageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<DataMovie>() {
            override fun areItemsTheSame(oldItem: DataMovie, newItem: DataMovie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataMovie, newItem: DataMovie): Boolean {
                return oldItem == newItem
            }

        }
    }


}