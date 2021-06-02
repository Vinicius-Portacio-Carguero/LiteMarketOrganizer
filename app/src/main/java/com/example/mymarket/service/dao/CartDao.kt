package com.example.mymarket.service.dao

import android.content.Context
import android.database.Cursor
import com.example.mymarket.service.data.DatabaseHelper

class CartDao(context: Context?) {
    var contextHelper = DatabaseHelper(context)

    fun insertProduct(Produto: String, Quantidade: String, Categoria: String, Valor: Int) {
        val db = contextHelper.writableDatabase
        db.execSQL("INSERT INTO shopCart(PRODUTO, QUANTIDADE, CATEGORIA, VALOR) VALUES('$Produto', '$Quantidade', '$Categoria', 2)")
    }


    val allData: Cursor
        get () {
            val db = contextHelper.writableDatabase
            val res = db.rawQuery("SELECT * FROM shopCart ", null )

            res.moveToFirst()

            while (res.moveToNext()) {
                println("Id : " + res.getString(0) + "\n")
                println("Produto : " + res.getString(1) + "\n")
                println("Quantidade : " + res.getString(2) + "\n")
                println("Categoria : " + res.getString(3) + "\n")
            }

            return res
        }
}