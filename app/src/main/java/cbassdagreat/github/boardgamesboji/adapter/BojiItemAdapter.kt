package cbassdagreat.github.boardgamesboji.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cbassdagreat.github.boardgamesboji.R
import cbassdagreat.github.boardgamesboji.databinding.ItemLayoutBinding
import cbassdagreat.github.boardgamesboji.model.BojiItem
import cbassdagreat.github.boardgamesboji.model.ListaBoji
import com.squareup.picasso.Picasso

class BojiItemAdapter : RecyclerView.Adapter<BojiItemAdapter.CustomViewHolder>() {

    class CustomViewHolder(itemView: View, var listener:MiOnClickListener) : RecyclerView.ViewHolder(itemView)
    {
        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(bojiItem: BojiItem)
        {
            with (binding)
            {
                Picasso.get().load(bojiItem.image).resize(100,100).into(ivImageLista)
                tvListaNom.text=bojiItem.name
                tvListaPubli.text=bojiItem.publisher
                itemView.setOnClickListener {
                    listener.onClickListener(bojiItem)
                }
            }
        }

    }

    private var lista:List<BojiItem> = ListaBoji()
    lateinit var listener:MiOnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateData(lista:List<BojiItem>)
    {
        this.lista=lista
        notifyDataSetChanged()
    }

    interface MiOnClickListener{
        fun onClickListener(bojiItem: BojiItem)
    }

    fun setMiOnClickListener(listener:MiOnClickListener)
    {
        this.listener = listener
    }
}