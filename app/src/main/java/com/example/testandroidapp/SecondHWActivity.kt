package com.example.testandroidapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondHWActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_homework)
        val jumpbutton = findViewById<Button>(R.id.jumpbutton)
        val callbutton = findViewById<Button>(R.id.callbutton)
        jumpbutton.setOnClickListener {
            startSecondActivity()
        }
        callbutton.setOnClickListener {
            call()
        }
    }

    private fun startSecondActivity() {
        val inputText = findViewById<EditText>(R.id.editTextText).text.toString()
        val intent = SecondHWTextActivity.createIntent(this, inputText)
        startActivity(intent)
    }

    private fun call() {
        val inputText = findViewById<EditText>(R.id.editTextPhone).text.toString()
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$inputText")
        }
        startActivity(intent)
    }
}