package com.example.cifranote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menuconfiguracoes, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return when (item.itemId)
        {
            R.id.action_settings ->
            {
                val intent = Intent(this, SettingActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun formatCifra(cifra: String) : String
    {
        val string = cifra as CharSequence

        val regex = Regex("/\\n/")
        val list = string.split(regex = regex)

        return list[0]
    }
}
