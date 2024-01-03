package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding  :ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = MovieAdapter(mutableListOf() , viewModel)
        binding.rvMovie.adapter = adapter
    }
}