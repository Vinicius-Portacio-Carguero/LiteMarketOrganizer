package com.example.mymarket.viewModel

import android.content.Context
import android.database.Cursor
import com.example.mymarket.service.dao.CartDao

class ListViewModel(context: Context?) {

    val contextViewModel = context

    fun insertValue(value: String){
        CartDao(contextViewModel).insertValue(value)
    }

    val selectAll: Cursor get () { return CartDao(contextViewModel).allPrices }

}