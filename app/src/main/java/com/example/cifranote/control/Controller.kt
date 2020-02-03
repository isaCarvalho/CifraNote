package com.example.cifranote.control

import android.content.ClipDescription
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

    fun insertMusica(name : String, key : String, description: String)
    {
        val musica = Musica(name, key, description)

        dbController.inserirDados(musica)
    }
}