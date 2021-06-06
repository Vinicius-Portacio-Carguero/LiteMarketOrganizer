package com.example.mymarket.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymarket.R
import com.example.mymarket.adapters.ListAdapter
import com.example.mymarket.domain.ProductValue
import com.example.mymarket.service.dao.CartDao
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.item_product_in_list.*


class ListFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater
            .inflate(
                R
                .layout
                .fragment_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appendData()


    }

    private fun fetchData(products: List<ProductValue>){
        recycler_view_main.apply{
            layoutManager = LinearLayoutManager(this.context)
            adapter = ListAdapter(products)

        }
    }

    private fun appendData(){
        val res = CartDao(context).allData
        val productList = mutableListOf<ProductValue>()


        res.moveToFirst()

        while(res.moveToNext()){
            productList.add(
                ProductValue(
                    res.getString(1),
                    res.getString(3),
                    res.getString(2),
                    res.getString(4)
                )
            )
        }

        println("@@@@@@@" + productList)
        fetchData(productList)
    }

    override fun onClick(v: View) { }
}
