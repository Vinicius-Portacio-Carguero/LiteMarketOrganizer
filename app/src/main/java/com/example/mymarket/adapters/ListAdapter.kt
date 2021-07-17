package com.example.mymarket.adapters

import android.content.Context
import android.graphics.Color
import com.example.mymarket.R
import com.example.mymarket.domain.ProductValue
import kotlinx.android.synthetic.main.item_product_in_list.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.example.mymarket.service.dao.CartDao
import com.example.mymarket.viewModel.CartViewModel
import com.example.mymarket.viewModel.ListViewModel
import kotlin.coroutines.coroutineContext

class ListAdapter( val products: List<ProductValue>): RecyclerView.Adapter<ListAdapter.ListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_in_list, parent, false)

        var btn_remove = view.findViewById<Button>(R.id.btn_remove)

        btn_remove.setOnClickListener {

            ListViewModel(view.context)
                .removeItem(view.findViewById<TextView>(
                    R
                    .id
                    .txt_product)
                        .text
                        .toString())

            view.findNavController().navigate(R.id.listFragment)


        }

        return ListViewHolder(view)

    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val products = products[position]

        holder.txt_emoji.text = products.emoji
        holder.txt_product.text = products.product
        holder.txt_category.text = products.category
        holder.txt_quantity.text = products.quantity

        holder.btn_buy.setOnClickListener {
            holder.layout.setBackgroundColor(Color.LTGRAY)
            holder.btn_buy.visibility = View.GONE
        }

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val txt_emoji: TextView = itemView.txt_emote
        val txt_product: TextView = itemView.txt_product
        val txt_category: TextView = itemView.txt_category
        val txt_quantity: TextView = itemView.txt_quantity

        val btn_buy: Button = itemView.btn_buy
        val btn_remove: Button = itemView.btn_remove
        val layout: RelativeLayout = itemView.layout_id
    }

}
