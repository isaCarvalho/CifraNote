package com.example.cifranote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.cifranote.control.Controller
import com.google.android.material.bottomnavigation.BottomNavigationView

class DisplayChordsActivity : AppCompatActivity() {

    private lateinit var chordsTextView: TextView
    private lateinit var nameTextView: TextView
    private val arraySizes = arrayOf(15F, 16F, 17F, 18F, 19F, 20F, 20.5F)
    private var pos = 0
    private lateinit var favorito : String
    private lateinit var id : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_chords)

        val chords = intent.getStringArrayExtra(EXTRA_MESSAGE)

        chordsTextView =  findViewById(R.id.chords)
        chordsTextView.apply {
            text = chords!![0]
        }

        nameTextView = findViewById(R.id.nameKey)
        nameTextView.apply {
            text = formatCifra(chords!![1])
        }

        favorito = chords!![2]

        id = chords!![3]
    }

    private fun formatCifra(cifra: String) : String
    {
        val string = cifra as CharSequence

        val regex = Regex("/\\n/")
        val list = string.split(regex = regex)

        return list[0]
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.menu.clear()
        bottomNavigationView.inflateMenu(R.menu.menubottom)
        return true
    }

    fun setFavorito(view : MenuItem)
    {
        Controller(this).setFavorito(this.favorito, this.id)
    }

    fun zoomIn(view : MenuItem)
    {
        pos++
        changeSize()
    }

    fun zoomOut(view : MenuItem)
    {
        pos--
        changeSize()
    }

    private fun changeSize()
    {
        if (pos <= 0)
            pos = 0
        else if (pos >= arraySizes.size)
            pos = arraySizes.size - 1

        this.chordsTextView.apply {
            textSize = arraySizes[pos]
        }


        this.nameTextView.apply {
            textSize = arraySizes[pos]
        }
    }

}
