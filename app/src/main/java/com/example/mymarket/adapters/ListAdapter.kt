package com.example.mymarket.adapters

import com.example.mymarket.R
import com.example.mymarket.domain.ProductValue
import kotlinx.android.synthetic.main.item_product_in_list.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter( val products: List<ProductValue>): RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_in_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val email = products[position]

        holder.txt_product.text = email.product
        holder.txt_category.text = email.category
        holder.txt_quantity.text = email.quantity
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val txt_product: TextView = itemView.txt_product
        val txt_category: TextView = itemView.txt_category
        val txt_quantity: TextView = itemView.txt_quantity
    }
}
