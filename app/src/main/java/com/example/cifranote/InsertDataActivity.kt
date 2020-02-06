package com.example.cifranote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cifranote.control.Controller
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class InsertDataActivity : AppCompatActivity() {

    private lateinit var salvar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        salvar = findViewById(R.id.salvar)

        salvar.setOnClickListener{
            val name = findViewById<EditText>(R.id.musicNameField).text.toString()
            val key = findViewById<EditText>(R.id.musicKeyField).text.toString()
            val description = findViewById<EditText>(R.id.musicDescriptionField).text.toString()

            if (name != "" && key != "") // so salva se tiver nome e tonalidade
                Controller(this).insertMusica(name, key, description)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
