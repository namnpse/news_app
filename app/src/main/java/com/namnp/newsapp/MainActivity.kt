package com.namnp.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.namnp.newsapp.databinding.ActivityMainBinding
import com.namnp.newsapp.presentation.NewsViewModel
import com.namnp.newsapp.presentation.NewsViewModelFactory
import com.namnp.newsapp.presentation.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var factory: NewsViewModelFactory
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController

        viewModel = ViewModelProvider(this, factory)[NewsViewModel::class.java]

        binding.bnvNews.setupWithNavController(
            navController
        )
    }
}