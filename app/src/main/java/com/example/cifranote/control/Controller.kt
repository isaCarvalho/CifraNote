package com.example.cifranote.control

import android.content.Context
import com.example.cifranote.database.ControladorBanco
import com.example.cifranote.model.Musica

class Controller(context: Context)
{
    private val dbController = ControladorBanco(context)

    fun getMusicas() : Array<Musica>
    {
        val list = dbController.lerDados()

        var musicas : Array<Musica> = Array(size = list.size){i ->
            list[i]
        }

        return musicas
    }
}