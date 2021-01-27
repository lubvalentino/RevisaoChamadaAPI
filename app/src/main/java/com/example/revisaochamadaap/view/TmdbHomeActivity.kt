package com.example.revisaochamadaap.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.revisaochamadaap.databinding.ActivityTmdbHomeBinding
import com.example.revisaochamadaap.model.Result
import com.example.revisaochamadaap.viewmodel.TmdbHomeViewModel

class TmdbHomeActivity : AppCompatActivity() {

    private lateinit var viewModel: TmdbHomeViewModel
    private lateinit var binding: ActivityTmdbHomeBinding
    private val tmdbHomeAdapter: TmdbHomeAdapter by lazy {
        TmdbHomeAdapter{
            val movieClicked = it
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTmdbHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadContent()
    }

    private fun loadContent() {
        viewModel = ViewModelProvider(this)[TmdbHomeViewModel::class.java]
//        viewModel.getTopRated()
        //vai chamar a lista automatica que vai se atualizando
        viewModel.moviePagedList?.observe(this,{pagedList ->
            tmdbHomeAdapter.submitList(pagedList)
        })
    }

//    nao usa no paging
//    private fun setupObservables() {
//        viewModel.onResultTopRated.observe(this,{
//            it?.let { topRated ->
//                setupRecyclerView(topRated.results)
//            }
//        })
//    }

    private fun setupRecyclerView() {
        binding.rvTmdbHome.apply {
            layoutManager = GridLayoutManager(this@TmdbHomeActivity, 2)
            adapter = tmdbHomeAdapter
        }
    }
}