package com.example.mymarket.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.mymarket.R
import com.example.mymarket.domain.EnumProducts
import com.example.mymarket.viewModel.CartViewModel
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater
                .inflate(R
                .layout
                .fragment_cart,
                    container,
                    false)

        return view
    }

    override fun onStart() {
        super.onStart()

        btn_clean
            .setOnClickListener { deleteList() }

        btn_register
            .setOnClickListener { registerProduct() }

        btn_to_list
            .setOnClickListener { findNavController().navigate(R.id.listFragment) }

        btn_import
            .setOnClickListener { findNavController().navigate(R.id.uploadFragment)}


        categorySetup()
    }

    override fun onClick(v: View) { }

    // input product, quantity and category
    // set last data
    // register last data

    fun doLastProduct(){

        val product = txt_product.text.toString()
        val quantity = txt_quantity.text.toString()

        last_product.text = product
        last_quantity.text = quantity

    }

    fun categorySetup(){

        var lista = resources.getStringArray(R.array.categories_values)

        spinner_category.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, lista)

        spinner_category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                last_category.text = lista[position]
            }

        }
    }

    private fun clearFields(){
        txt_product.text.clear()
        txt_quantity.text.clear()

        txt_product.hint = "Adicione o próximo produto"
    }

    private fun registerProduct() {

        doLastProduct()

        var product = last_product.text.toString()
        var quantity = last_quantity.text.toString()
        var category = last_category.text.toString()
        var emoji = defineEmoji(last_category.text.toString())


        Log.i("Inserting", "Produto: $product, Quantidade: $quantity, Categoria: $category, emoji: $emoji")
        CartViewModel(context).insert(product, quantity, category, emoji)

//        clearFields()

    }

    private fun fetchProducts() {
        CartViewModel(context).selectAll
    }

    private fun defineEmoji(category: String): String{

        val emojiValidation =
           when(category){
               EnumProducts.LIMPEZA.productType -> return "\uD83E\uDDF9 "
               EnumProducts.ANIMAIS.productType -> return "🐶"
               EnumProducts.FRUTAS.productType -> return "🍎 "
               EnumProducts.FRIOS.productType -> return "🧀 "
               EnumProducts.HIGIENEPESSOAL.productType -> return "\uD83E\uDDFC"
               EnumProducts.GRAOS.productType -> return "\uD83C\uDF5A"
               EnumProducts.CARNES.productType -> return "\uD83E\uDD69"
               EnumProducts.LATICINIOS.productType -> return "\uD83E\uDD5B"
               EnumProducts.MATINAIS.productType -> return "\uD83C\uDF6A"
               EnumProducts.MASSAS.productType -> return "\uD83C\uDF5D "
               else -> "❓"
           }
        return emojiValidation
    }

    private fun deleteList(){
        CartViewModel(context).cleanList()
    }

}


