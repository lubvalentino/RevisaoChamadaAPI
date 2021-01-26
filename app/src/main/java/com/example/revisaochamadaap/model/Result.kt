package com.example.revisaochamadaap.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val adult: Boolean,
    //colocar o nome no padrão
    //value é como veio da API
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    var title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
):Parcelable{

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<Result> = object : DiffUtil.ItemCallback<Result>(){
            //vai indo um por um e vendo se é o mesmo
            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
    }