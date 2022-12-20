package com.yapp.presentation

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yapp.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val mainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                mainViewModel.resultState.collect{
                    when(it){
                        MainResultState.None -> {
                            binding.tvResult.typeface = Typeface.DEFAULT
                            binding.tvResult.text = ""
                        }
                        is MainResultState.Success -> {
                            binding.tvResult.typeface = Typeface.DEFAULT_BOLD
                            binding.tvResult.text = it.mainViewState.result
                        }
                        is MainResultState.Error -> {
                            Toast.makeText(this@MainActivity, "계산 실패", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        initCalculatorHistory()
    }

    private fun initCalculatorHistory(){
        binding.rvResults.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                mainViewModel.historyState.collect{
                    Log.d("msg","initCalculatorHistory")
                    mainAdapter.setItem(it)
                }
            }
        }
    }
}