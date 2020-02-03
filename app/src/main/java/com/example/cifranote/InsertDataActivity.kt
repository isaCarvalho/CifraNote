package com.example.cifranote

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
            val name = findViewById<EditText>(R.id.musicNameField)
            val key = findViewById<EditText>(R.id.musicKeyField)
            val description = findViewById<EditText>(R.id.musicDescriptionField)

            Controller(this).insertMusica(name.text.toString(), key.text.toString(), description.text.toString())
        }
    }
}
