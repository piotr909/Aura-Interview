package com.piotrapps.aurainterview.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.piotrapps.aurainterview.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: setup ui for changing allowed dismissal count and interval

        subscribeUi()

        handleNotification(intent)
    }

    private fun handleNotification(intent: Intent) {
        //TODO: implement
    }

    private fun subscribeUi() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    mainViewModel.bootTimes.collectLatest {
                        val builder = StringBuilder()
                        it?.bootTimes?.forEach {
                            builder.appendLine(it)
                        }

                        binding.bootList.text = builder.toString()

                        //TODO: fill allowed dismissal count and interval from ui state
                    }
                }
            }
        }
    }
}