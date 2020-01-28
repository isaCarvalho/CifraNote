package com.example.cifranote.control

import android.content.Context
import com.example.cifranote.database.ControladorBanco

class Controller(context: Context)
{
    private lateinit var musicas : Array<String>
    private val dbController = ControladorBanco(context)

    fun getMusicas() : Array<String>
    {
        val list = dbController.lerDados()
        this.musicas = Array(list.size) {i ->
            "${list[i].nome} (${list[i].tom}) "
        }

        return this.musicas
    }
}