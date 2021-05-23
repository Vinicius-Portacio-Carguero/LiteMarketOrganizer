package com.example.mymarket.service.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "SHOPDB"

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1 ){
    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("CREATE TABLE shopCart(ID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUTO TEXT, QUANTIDADE TEXT, CATEGORIA TEXT, VALOR INTEGER )")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS SHOPDB")
        onCreate(db)
    }

    fun insertProduct(Produto: String, Quantidade: String, Categoria: String, Valor: Int) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
            contentValues.put("PRODUTO", Produto)
            contentValues.put("QUANTIDADE", Quantidade)
            contentValues.put("CATEGORIA", Categoria)
            contentValues.put("VALOR", Valor)

            db.insert("shopCart", null, contentValues)

    }

    val allData: Cursor
        get () {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM shopCart ORDER BY ID DESC", null )
            println(res.getString(10))
            return res
        }

}