package com.example.testandroidapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondHWTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_homework_text)
        val textView = findViewById<TextView>(R.id.textFromInput)
        val receivedValue = intent.getStringExtra(EXTRA_DATA)
        textView.text = receivedValue
    }

    companion object {
        private const val EXTRA_DATA = "EXTRA_DATA"

        fun createIntent(context: Context, data: String): Intent {
            return Intent(context, SecondHWTextActivity::class.java)
                .putExtra(EXTRA_DATA, data)
        }
    }
}
