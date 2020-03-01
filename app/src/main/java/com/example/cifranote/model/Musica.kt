package com.example.cifranote.model

data class Musica(val id: Int, val nome : String, val tom: String, val descricao: String)
{
    private var favorito : String = "false"

    fun setFavorito(favorito : String) { this.favorito = favorito }

    fun getFavorito() : String
    {
        return this.favorito
    }
}