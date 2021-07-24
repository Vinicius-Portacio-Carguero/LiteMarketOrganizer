package com.example.mymarket.service.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, "SHOPDB", null, 1 ){
    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("CREATE TABLE shopCart(ID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUTO TEXT, QUANTIDADE TEXT, CATEGORIA TEXT, EMOJI TEXT)")
        db.execSQL("INSERT INTO shopCart(PRODUTO, QUANTIDADE, CATEGORIA, EMOJI) VALUES('Produto', 'Quantidade', 'Categoria', '@')")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS shopCart")
        onCreate(db)
    }


}