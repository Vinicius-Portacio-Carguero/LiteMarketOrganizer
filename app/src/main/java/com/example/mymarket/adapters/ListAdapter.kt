package com.example.mymarket.adapters

import com.example.mymarket.R
import com.example.mymarket.domain.ProductValue
import kotlinx.android.synthetic.main.item_product_in_list.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter( val products: List<ProductValue>): RecyclerView.Adapter<ListAdapter.ListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_in_list, parent, false)
        return ListViewHolder(view)

    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val products = products[position]

        holder.txt_emoji.text = products.emoji
        holder.txt_product.text = products.product
        holder.txt_category.text = products.category
        holder.txt_quantity.text = products.quantity

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val txt_emoji: TextView = itemView.txt_emote
        val txt_product: TextView = itemView.txt_product
        val txt_category: TextView = itemView.txt_category
        val txt_quantity: TextView = itemView.txt_quantity
        val layout: RelativeLayout = itemView.layout_id
    }

}
