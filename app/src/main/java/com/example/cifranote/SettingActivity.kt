package com.example.cifranote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val spinnerFamily: Spinner = findViewById(R.id.spinnerFamily)

        ArrayAdapter.createFromResource(this, R.array.family_array, android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinnerFamily.adapter = adapter
        }


        val spinnerSizes: Spinner = findViewById(R.id.spinnerSizes)

        ArrayAdapter.createFromResource(this, R.array.sizes_array, android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinnerSizes.adapter = adapter
        }

        val spinnerColors : Spinner = findViewById(R.id.spinnerColors)

        ArrayAdapter.createFromResource(this, R.array.colors_array, android.R.layout.simple_spinner_item)
            .also { adapter ->

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                spinnerColors.adapter = adapter
            }
    }
}
