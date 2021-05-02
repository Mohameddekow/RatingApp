package com.example.ratingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

            val rating = rating.toString()

            tvRating.text = rating
        }

        send.setOnClickListener {
            etSaySomething.text?.clear()

            Toast.makeText(applicationContext, "Your Review is Submitted To ERIC G.", Toast.LENGTH_SHORT).show()
        }

    }
}