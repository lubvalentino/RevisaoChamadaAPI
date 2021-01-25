package com.example.revisaochamadaap.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.revisaochamadaap.R
import com.example.revisaochamadaap.databinding.ActivityTmdbHomeBinding
import com.example.revisaochamadaap.databinding.TmdbListItemBinding
import com.example.revisaochamadaap.model.Result

class TmdbHomeAdapter (
    private val movieslist: List<Result>
        ) : RecyclerView.Adapter<TmdbHomeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TmdbListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieslist[position])
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

    class ViewHolder (
        private val binding: TmdbListItemBinding
            )
        : RecyclerView.ViewHolder(
        binding.root
    ) {
       fun bind(movies: Result) = with(binding){
           Glide.with(itemView.context).load(movies.posterPath)
                   //colocar um imagem enquato não carrega a original
               .placeholder(R.drawable.ic_android_black_24dp)
               .into(ivTmdbHomePoster)
           tvTmdbName.text=movies.title
       }
    }
}