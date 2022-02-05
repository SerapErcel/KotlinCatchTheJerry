package com.example.kotlincatchthejerry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kotlincatchthejerry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var score = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //CountDown Timer
        object : CountDownTimer(15000, 1000) {
            override fun onFinish() {
                binding.timeText.text = "Time: 0"

                //Alert
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart The Game?")
                alert.setPositiveButton("Yes") { dialog, which ->
                    //Restart
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No") { dialog, which ->
                    Toast.makeText(this@MainActivity, "Game Over", Toast.LENGTH_LONG).show()
                }
                alert.show()

            }

            override fun onTick(p0: Long) {
                binding.timeText.text = "Time: " + p0 / 1000
            }


        }.start()
    }

    fun increaseScore(view: View) {
        score = score + 1
        binding.scoreText.text = "Score: $score"
    }
}