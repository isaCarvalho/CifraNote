package com.example.cifranote

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cifranote.model.Musica

const val EXTRA_MESSAGE = "com.exemple.cifranote.MESSAGE"

class MyAdapter(private val myDataset: Array<Musica>): RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    class MyViewHolder (val v: View) : RecyclerView.ViewHolder(v)
    {
        val textView: TextView = v.findViewById(R.id.musicName)
        val cardView: CardView = v.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val string = "${myDataset[position].nome} (${myDataset[position].tom})"
        holder.textView.text = string

        holder.cardView.setOnClickListener{ v ->

            val intent = Intent(v.context, DisplayCifraActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, myDataset[position].descricao)
            }.also {

                startActivity(v.context, it, null)
            }
        }
    }

    override fun getItemCount(): Int = myDataset.size
}