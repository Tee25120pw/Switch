package com.example.aswitch

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aswitch.R.id.textView3

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        Log.i("message","$message")

        // Capture the layout's TextView and set the string as its text
        val textView3 = findViewById<TextView>(textView3).apply {
            text = message
            Log.i("text","$text")
        }
    }
}