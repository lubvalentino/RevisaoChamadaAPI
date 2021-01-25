package com.example.revisaochamadaap.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.revisaochamadaap.R
import com.example.revisaochamadaap.databinding.ActivityTmdbHomeBinding
import com.example.revisaochamadaap.model.Result
import com.example.revisaochamadaap.viewmodel.TmdbHomeViewModel

class TmdbHomeActivity : AppCompatActivity() {

    private lateinit var viewModel: TmdbHomeViewModel
    private lateinit var binding: ActivityTmdbHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmdbHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TmdbHomeViewModel::class.java)
        viewModel.getTopRated()
        setupObservables()
    }

    private fun setupObservables() {
        viewModel.onResultTopRated.observe(this,{
            it?.let { topRated ->
                setupRecyclerView(topRated.results)
            }
        })
    }

    private fun setupRecyclerView(movies: List<Result>) {
        binding.rvTmdbHome.apply {
            layoutManager = GridLayoutManager(this@TmdbHomeActivity, 2)
            adapter = TmdbHomeAdapter(movies)
        }
    }
}