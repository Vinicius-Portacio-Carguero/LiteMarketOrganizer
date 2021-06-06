package com.example.mymarket.adapters

import com.example.mymarket.R
import com.example.mymarket.domain.ProductValue
import kotlinx.android.synthetic.main.item_product_in_list.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.mymarket.viewModel.CartViewModel
import com.example.mymarket.viewModel.ListViewModel
import kotlin.coroutines.coroutineContext

class ListAdapter( val products: List<ProductValue>): RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    val ListContext = ListFragment().context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_in_list, parent, false)
        return ListViewHolder(view)

        var btn_buy = view.findViewById<Button>(R.id.btn_buy)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val products = products[position]

        holder.txt_emoji.text = products.emoji
        holder.txt_product.text = products.product
        holder.txt_category.text = products.category
        holder.txt_quantity.text = products.quantity

        holder.txt_value.text = null

        holder.btn_buy.setOnClickListener {
            println("@@@@@@@")

            ListViewModel(ListContext)
                .insertValue(holder
                    .txt_value
                    .text
                    .toString())

            CartViewModel(ListContext).selectAll

        }

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val txt_emoji: TextView = itemView.txt_emote
        val txt_product: TextView = itemView.txt_product
        val txt_category: TextView = itemView.txt_category
        val txt_quantity: TextView = itemView.txt_quantity

        val txt_value: TextView by lazy {  itemView.txt_value}
        val btn_buy: Button by lazy { itemView.btn_buy }

    }

}
