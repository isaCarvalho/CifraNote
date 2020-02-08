package com.example.cifranote

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cifranote.control.Controller
import com.example.cifranote.model.Musica
import org.w3c.dom.Text

const val EXTRA_MESSAGE = "com.exemple.cifranote.MESSAGE"

class MyAdapter(private val myDataset: Array<Musica>): RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    class MyViewHolder (v: View) : RecyclerView.ViewHolder(v)
    {
        val textView: TextView = v.findViewById(R.id.musicName)
        val textViewKey : TextView = v.findViewById(R.id.musicKey)
        val cardView: CardView = v.findViewById(R.id.card_view)
        val imageDelete : ImageView = v.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataset[position].nome
        holder.textViewKey.text = myDataset[position].tom

        holder.cardView.setOnClickListener{ v ->

            Intent(v.context, DisplayCifraActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, myDataset[position].descricao)
            }.also {

                startActivity(v.context, it, null)
            }
        }

        holder.imageDelete.setOnClickListener{v ->
            Controller(v.context).deleteMusica(myDataset[position].id)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = myDataset.size
}