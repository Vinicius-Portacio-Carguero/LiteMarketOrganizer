package com.example.mymarket.service.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, "SHOPDB", null, 1 ){
    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("CREATE TABLE shopCart(ID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUTO TEXT, QUANTIDADE TEXT, CATEGORIA TEXT, VALOR INTEGER )")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS shopCart")
//        onCreate(db)
    }

    var db: SQLiteDatabase? = null

    fun insertProduct(Produto: String, Quantidade: String, Categoria: String, Valor: Int) {
        val db = this.writableDatabase
        db?.execSQL("INSERT INTO shopCart(PRODUTO, QUANTIDADE, CATEGORIA, VALOR) VALUES('$Produto', '$Quantidade', '$Categoria', 2)")

    }

    val allData: Cursor
        get () {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM shopCart ", null )
            res.moveToFirst()

            println(res.count)

            while (res.moveToNext()) {
                println("Id : " + res.getString(0) + "\n")
                println("Produto : " + res.getString(1) + "\n")
                println("Quantidade : " + res.getString(2) + "\n")
                println("Categoria : " + res.getString(3) + "\n")
            }

            return res
        }

}