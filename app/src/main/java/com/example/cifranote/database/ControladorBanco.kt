package com.example.cifranote.database

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import com.example.cifranote.model.Musica

class ControladorBanco(private val context: Context)
{
    private val dbHelper = CriaBanco(context)

    fun inserirDados(name : String, key : String, description : String)
    {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(CriaBanco.FeedReaderContract.FeedEntry.NAME,name)
            put(CriaBanco.FeedReaderContract.FeedEntry.KEY, key)
            put(CriaBanco.FeedReaderContract.FeedEntry.DESCRICAO, description)
        }

        val newRowId = db?.insert(CriaBanco.FeedReaderContract.FeedEntry.TABLE_NAME, null, values)
    }

    fun deletarDados(id: Int)
    {
        val db = dbHelper.writableDatabase

        db.execSQL("DELETE FROM musics WHERE ${BaseColumns._ID} = $id")
    }

    fun lerDados() : MutableList<Musica>
    {
        val db = dbHelper.readableDatabase

        val projection = arrayOf(BaseColumns._ID, CriaBanco.FeedReaderContract.FeedEntry.NAME,
            CriaBanco.FeedReaderContract.FeedEntry.KEY, CriaBanco.FeedReaderContract.FeedEntry.DESCRICAO)

        val cursor = db.query(
            CriaBanco.FeedReaderContract.FeedEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val items = mutableListOf<Musica>()
        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(BaseColumns._ID))
                val name = getString(getColumnIndexOrThrow(CriaBanco.FeedReaderContract.FeedEntry.NAME))
                val key = getString(getColumnIndexOrThrow(CriaBanco.FeedReaderContract.FeedEntry.KEY))
                val description = getString(getColumnIndexOrThrow(CriaBanco.FeedReaderContract.FeedEntry.DESCRICAO))
                items.add(Musica(id, name, key, description))
            }
        }

        cursor.close()

        return items
    }
}