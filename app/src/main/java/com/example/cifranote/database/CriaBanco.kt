package com.example.cifranote.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class CriaBanco(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)
{
    object FeedReaderContract
    {
        object FeedEntry : BaseColumns
        {
            const val TABLE_NAME = "musics"
            const val NAME = "name"
            const val KEY= "music_key"
            const val DESCRICAO = "description"
            const val FAVORITO = "favorite"
        }
    }


    override fun onCreate(db: SQLiteDatabase?)
    {
        var string = "CREATE TABLE ${FeedReaderContract.FeedEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY, " +
                "${FeedReaderContract.FeedEntry.NAME} TEXT, " +
                "${FeedReaderContract.FeedEntry.KEY} TEXT, " +
                "${FeedReaderContract.FeedEntry.DESCRICAO} TEXT, " +
                "${FeedReaderContract.FeedEntry.FAVORITO} TEXT )"

        db!!.execSQL(string)

        string = "INSERT INTO ${FeedReaderContract.FeedEntry.TABLE_NAME} (name, music_key, description, favorite) VALUES" +
        "('Imutavel Deus', 'G', 'É tempo de reconstruir, reerguer as muralhas, dispondo-se a trabalhar, e nao olhar atras...', 'false')," +
        "('Cidade Eternal', 'Em', 'Constrangidos pelo amor do nosso Deus, caminhamos para a nova Jerusalem...', 'true')," +
        "('Aos pes de Jesus', 'F', 'Aos pes de Jesus e onde encontro...', 'false')," +
        "('Mais que maravilhoso','Eb', 'Jesus nos prometeu conselheiro ser...', 'true'), " +
        "('Aquele que ha de vir vira', 'A', 'Aquele que ha de vir vira e nao tardara...', 'false'), " +
        "('O Senhor e a minha rocha', 'Bb', 'Quando paro pra pensar em Teu grande Amor...', 'true'), " +
        "('Bodas do Cordeiro', 'Dm', 'Ouvi no ceu a voz de uma multidao....', 'false'), " +
        "('Nao se turbe o vosso coracao', 'A', 'Nao se turbe o vosso coracao, crede sempre em Deus, crede em mim', 'true')"

        db.execSQL(string)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        db!!.execSQL("DROP TABLE IF EXISTS ${FeedReaderContract.FeedEntry.TABLE_NAME}")
        onCreate(db)
    }

    companion object
    {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "CifraNote.db"
    }
}