package com.example.mymarket.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymarket.Repository.CartRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class CartViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var repository: CartRepository

    fun insert(Produto: String, Quantidade: String, Categoria: String, Emoji: String){
        viewModelScope.launch {
            try{

                repository.insert(Produto, Quantidade, Categoria, Emoji)

            } catch (e: Exception){

            }
        }
    }

}