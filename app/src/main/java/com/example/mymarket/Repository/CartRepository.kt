package com.example.mymarket.Repository

import android.database.Cursor
import com.example.mymarket.service.dao.CartDao
import javax.inject.Inject

class CartRepository @Inject constructor(private val cartDao: CartDao) {

    suspend fun insert(Produto: String, Quantidade: String, Categoria: String, Emoji: String){
        cartDao?.insertProduct(Produto, Quantidade, Categoria, Emoji)
    }

    val selectAll: Cursor get () { return cartDao.allData }


    fun cleanList(){
        cartDao?.deleteAll()
    }
}