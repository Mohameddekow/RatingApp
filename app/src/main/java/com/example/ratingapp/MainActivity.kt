package com.example.ratingapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ratingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // use getter to get non-null value for binding variable
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        captureRating()
    }

    @SuppressLint("SetTextI18n") // ignore concatenation warning
    private fun captureRating() {
        var userRating = 0F // initial value

        // use _ for unused parameters in this lambda function
        binding.ratingBar.apply {
            setOnRatingBarChangeListener { _, rating, _ ->
                userRating = rating.also {
                    binding.tvRating.text = "${it.toInt()}/5"
                }
            }
        }

        binding.btnSend.setOnClickListener {
            if (binding.etRating.text!!.isNotEmpty()) {
                Toast.makeText(this, "Rating ($userRating/5.0) sent to Moha", Toast.LENGTH_SHORT)
                    .show()
            } else {
                binding.etRating.error = "can't be blank"
            }
        }
    }
}