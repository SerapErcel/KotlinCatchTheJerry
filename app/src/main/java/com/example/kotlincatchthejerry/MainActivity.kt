package com.example.kotlincatchthejerry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlincatchthejerry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var score = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun increaseScore(view: View) {
        score = score + 1
        binding.scoreText.text = "Score: $score"
    }
}