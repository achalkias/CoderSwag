package com.achalkias.coderswag.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.achalkias.coderswag.Adapters.CategoryAdapter
import com.achalkias.coderswag.R
import com.achalkias.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this,
                DataService.categories)

        categoryListView.adapter = adapter
    }
}
