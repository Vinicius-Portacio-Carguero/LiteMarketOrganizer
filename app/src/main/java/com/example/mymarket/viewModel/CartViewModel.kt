package com.example.mymarket.viewModel

import android.content.Context
import android.database.Cursor
import com.example.mymarket.service.dao.CartDao

class CartViewModel(context: Context?) {

    val contextViewModel = context


    fun insert(Produto: String, Quantidade: String, Categoria: String, Emoji: String){
        val dao = CartDao(contextViewModel)
        dao?.insertProduct(Produto, Quantidade, Categoria, Emoji)
    }

    val selectAll: Cursor get () { return CartDao(contextViewModel).allData }


    fun cleanList(){
        val dao = CartDao(contextViewModel)
        dao?.deleteAll()
    }
}