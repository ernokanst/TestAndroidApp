package com.example.testandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InitialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.initial_screen)
        val homework1 = findViewById<Button>(R.id.hw1button)
        val homework2 = findViewById<Button>(R.id.hw2button)
        homework1.setOnClickListener {
            startMainActivity()
        }
        homework2.setOnClickListener {
            startSecondActivity()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun startSecondActivity() {
        startActivity(Intent(this, SecondHWActivity::class.java))
    }
}