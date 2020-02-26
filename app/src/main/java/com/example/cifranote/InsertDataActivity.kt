package com.example.cifranote

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cifranote.control.Controller
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

private const val READ_REQUEST_CODE : Int = 42

class InsertDataActivity : AppCompatActivity() {

    private lateinit var salvar : Button
    private lateinit var buttonPicker : Button
    private var description : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        salvar = findViewById(R.id.salvar)

        salvar.setOnClickListener{
            val name = findViewById<EditText>(R.id.musicNameField).text.toString()
            val key = findViewById<EditText>(R.id.musicKeyField).text.toString()

            if (name != "" && key != "") // so salva se tiver nome e tonalidade
                Controller(this).insertMusica(name, key, description)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonPicker = findViewById(R.id.filePicker)
        buttonPicker.setOnClickListener{
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)

                type = "text/plain"
            }

            startActivityForResult(intent, READ_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            resultData?.data?.also { uri ->
                findViewById<TextView>(R.id.fileName).text = uri.path

                val stringBuilder = StringBuilder()
                contentResolver.openInputStream(uri).use { inputStream ->
                    BufferedReader(InputStreamReader(inputStream!!)).use { reader ->
                        val line : String? = reader.readText()
                        stringBuilder.append(line)
                    }
                }

                this.description = stringBuilder.toString()
            }
        }
    }
}
