package com.example.mymarket.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymarket.R
import com.example.mymarket.adapters.ListAdapter
import com.example.mymarket.domain.EnumProducts
import com.example.mymarket.domain.ProductValue
import com.example.mymarket.service.dao.CartDao
import com.example.mymarket.viewModel.CartViewModel
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_upload.*


class UploadFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater
            .inflate(
                R
                    .layout
                    .fragment_upload, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = field_import.text.toString()

        btn_process.setOnClickListener {
            println("@@@@")
            println(list)

            processList(list)
        }
    }

    fun processList(list: String) {
        var splitedList = list.split(",")

        println(splitedList)


    }

    override fun onClick(v: View) { }
}
