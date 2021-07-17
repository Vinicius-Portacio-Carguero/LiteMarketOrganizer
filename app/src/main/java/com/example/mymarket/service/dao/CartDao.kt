package com.example.mymarket.service.dao

import android.content.Context
import android.database.Cursor
import com.example.mymarket.service.data.DatabaseHelper

class CartDao(context: Context?) {
    var contextHelper = DatabaseHelper(context)

    fun insertProduct(Produto: String, Quantidade: String, Categoria: String, Emoji: String) {
        val db = contextHelper.writableDatabase
        db.execSQL("INSERT INTO shopCart(PRODUTO, QUANTIDADE, CATEGORIA, EMOJI) VALUES('$Produto', '$Quantidade', '$Categoria', '$Emoji')")
    }

    fun deleteAll(){
        val db = contextHelper.writableDatabase
        db.execSQL("DELETE FROM shopCart")
    }

    val allData: Cursor
        get () {
            val db = contextHelper.writableDatabase
            val res = db.rawQuery("SELECT * FROM shopCart ORDER BY CATEGORIA ASC", null )

            res.moveToFirst()

            while (res.moveToNext()) {
                println("Id : " + res.getString(0) + "\n")
                println("Produto : " + res.getString(1) + "\n")
                println("Quantidade : " + res.getString(2) + "\n")
                println("Categoria : " + res.getString(3) + "\n")
            }

            return res
        }

    fun deleteSelected(Product: String){

        val db = contextHelper.writableDatabase
            db.execSQL("DELETE FROM shopCart WHERE PRODUTO = '$Product'")
    }
}