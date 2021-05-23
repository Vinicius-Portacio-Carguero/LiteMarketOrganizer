package com.example.mymarket.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import com.example.mymarket.R
import com.example.mymarket.service.data.DatabaseHelper
import com.example.mymarket.viewModel.CartViewModel
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        val btn_register = view.findViewById<Button>(R.id.btn_register)

        btn_register.setOnClickListener {

            val textProduct = txt_product.text.toString()
            val textQuantity = txt_quantity.text.toString()

            if(textQuantity.length > 2) { quantityValueValidation() }
                else { setLastProduct(textProduct, textQuantity)}

            when(last_category.text){
                null -> last_category.text = "Sem categoria"
                "" -> last_category.text = "Sem categoria"
                " " -> last_category.text = "Sem categoria"
            }
        }

        return view

    }

    override fun onStart() {
        super.onStart()

        val helper = context?.let { DatabaseHelper(it) }

        val res = helper?.allData

            if(res?.count == 0 ) {
                println("@@@@@ ------> BANCO DE DADOS VAZIO")
            }


        while(res?.moveToNext()!!){
            println("ID" + res.getString(50))
        }

    }


    override fun onClick(v: View) { }

    fun setLastProduct(product: String, quantity: String) {

        txt_quantity.setTextColor(Color.parseColor("#363636"))

        println("Produto = $product // Quantidade = $quantity // Categoria: ${CategoryValidation()}")

        last_product.text = product
        last_quantity.text = quantity
        last_category.text = CategoryValidation()
    }

    fun quantityValueValidation() {

        txt_quantity.setTextColor(Color.parseColor("#fc2c03"))
        txt_product.setText("")
        txt_product.setHint("Valor não permitido")

    }

    fun CategoryValidation() : String{
        var checkBoxText = ""

        val checkBoxArr = listOf<CheckBox>(
            checkBox, checkBox2,
            checkBox3, checkBox4,
            checkBox5, checkBox6,
            checkBox7, checkBox8,
            checkBox9, checkBox10
        )

        for(i in 0..checkBoxArr.size - 1){

             if(checkBoxArr[i].isChecked) { checkBoxText = checkBoxArr[i].text.toString() }

        }

        return checkBoxText
    }


}


