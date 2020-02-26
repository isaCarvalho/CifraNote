package com.example.cifranote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayChordsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_chords)

        val chords = intent.getStringArrayExtra(EXTRA_MESSAGE)

        findViewById<TextView>(R.id.chords).apply {
            text = chords!![0]
        }

        findViewById<TextView>(R.id.nameKey).apply {
            text = formatCifra(chords!![1])
        }
    }

    private fun formatCifra(cifra: String) : String
    {
        val regex = Regex("/\\n/")
        val list = cifra.split(regex = regex)

        return list[0]
    }
}
