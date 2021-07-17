package com.example.mymarket.viewModel

import android.content.Context
import com.example.mymarket.service.dao.CartDao

class ListViewModel(context: Context?) {

    val contextViewModel = context

    fun removeItem(product: String) {
        val dao = CartDao(contextViewModel)
        dao?.deleteSelected(product)
    }

}