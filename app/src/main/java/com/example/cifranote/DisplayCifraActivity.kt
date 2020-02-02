package com.example.cifranote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayCifraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_cifra)

        val cifra = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.cifra).apply {
            text = cifra
        }
    }
}
