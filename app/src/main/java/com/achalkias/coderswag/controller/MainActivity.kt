package com.achalkias.coderswag.controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.achalkias.coderswag.Adapters.CategoryRecyclerAdapter
import com.achalkias.coderswag.R
import com.achalkias.coderswag.services.DataService
import com.achalkias.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(this,
                DataService.categories) { category ->
            //Open products activity
            val productActivity = Intent(this, ProductsActivity::class.java)
            productActivity.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productActivity)
        }
        categoryRecyclerView.adapter = adapter
        categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        categoryRecyclerView.setHasFixedSize(true)
    }
}
