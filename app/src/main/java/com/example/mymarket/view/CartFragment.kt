package com.example.mymarket.view

import android.content.Context
import android.database.Cursor
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import com.example.mymarket.MainActivity
import com.example.mymarket.R
import com.example.mymarket.service.dao.CartDao
import com.example.mymarket.service.data.DatabaseHelper
import com.example.mymarket.viewModel.CartViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : Fragment(), View.OnClickListener {

    private var helper: DatabaseHelper = DatabaseHelper(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater
        .inflate(R
                .layout
                .fragment_cart, container, false)

        return view }


    override fun onStart() {
        super.onStart()

        btn_save.setOnClickListener { fetchProducts() }

        btn_register.setOnClickListener { formatAndRegister() }

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

    /**   Repository Formatters   **/

    fun formatAndRegister(){
        val textProduct = txt_product.text.toString()
        val textQuantity = txt_quantity.text.toString()

        if(textQuantity.length > 2) { quantityValueValidation() }
        else { setLastProduct(textProduct, textQuantity)}

        when(last_category.text){
            null -> last_category.text = "Sem categoria"
            "" -> last_category.text = "Sem categoria"
            " " -> last_category.text = "Sem categoria"
        }
        registerProduct()
    }

    private fun registerProduct() {

        var product = last_product.text.toString()
        var quantity = last_quantity.text.toString()
        var category = last_category.text.toString()
        var value = 0


        CartViewModel(context).insert(product, quantity, category, value)


    }

    private fun fetchProducts() {
        CartViewModel(context).selectAll
    }
}


