package com.example.mymarket.viewModel

import com.example.mymarket.service.ServiceDAO

class CartViewModel {

    var serviceDao = ServiceDAO()

    fun insert(Produto: String, Quantidade: String, Categoria: String, Valor: Int) { serviceDao.insertProduct(Produto, Quantidade, Categoria, Valor) }

    fun getAll(){serviceDao.allData}
}