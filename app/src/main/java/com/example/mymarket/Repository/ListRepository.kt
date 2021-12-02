package com.example.mymarket.Repository

import android.content.Context
import com.example.mymarket.service.dao.CartDao

class ListRepository(context: Context?) {

    val contextViewModel = context

    fun removeItem(product: String) {
        val dao = CartDao(contextViewModel)
        dao?.deleteSelected(product)
    }

}