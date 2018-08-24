package com.martinsvitols.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.martinsvitols.coderswag.Adapters.ProductsAdapter
import com.martinsvitols.coderswag.R
import com.martinsvitols.coderswag.Services.DataService
import com.martinsvitols.coderswag.Utilities.EXTRA_CATEGORY
import com.martinsvitols.coderswag.Utilities.EXTRA_ITEM
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)) {product ->
            val itemIntent = Intent(this, ItemActivity::class.java)
            itemIntent.putExtra(EXTRA_ITEM, product)
            startActivity(itemIntent)
        }

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }
        val layoutManager = GridLayoutManager(this, spanCount)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter
    }
}
