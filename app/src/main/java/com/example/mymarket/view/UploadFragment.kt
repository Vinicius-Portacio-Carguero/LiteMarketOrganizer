package com.example.mymarket.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mymarket.R
import com.example.mymarket.Repository.CartRepository
import kotlinx.android.synthetic.main.fragment_upload.*


class UploadFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater
            .inflate(
                R
                    .layout
                    .fragment_upload, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_process.setOnClickListener {
            insertValueAndProduct()
        }
    }

    fun doPersist(product: String, quantity: String, category : String, emoji: String){
//        CartRepository(context).insert(product, quantity, category, emoji)

    }

    fun insertValueAndProduct(){

        val list = realocateElementsInList()

        for(i in 0..list.size -2){
            val splitedList = list[i+1].split("-")

            val quantity = splitedList[0]
            val product = splitedList[1]

            println("Q: $quantity P: $product")

            doPersist(product, quantity, "Sem categoria", "❓")
        }

        findNavController().navigate(R.id.listFragment)

    }

    fun realocateElementsInList(): MutableList<String>{

        val list = mutableListOf("items> ")

        val splitList = splitElements(field_import.text.toString())

        for(i in 0..splitList.size - 1){
            list.add(i + 1, splitList[i])
        }
        println(list)
        return list
    }

    fun splitElements(list: String): MutableList<String> {
        var splitedList = list
            .split(",")
            .toMutableList()

        return splitedList
    }


    override fun onClick(v: View) { }
}
