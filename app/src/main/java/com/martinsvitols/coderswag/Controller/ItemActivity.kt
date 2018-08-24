package com.martinsvitols.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.martinsvitols.coderswag.Model.Product
import com.martinsvitols.coderswag.R
import com.martinsvitols.coderswag.Utilities.EXTRA_ITEM
import kotlinx.android.synthetic.main.activity_item_individual.*

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_individual)


        val item = intent.getParcelableExtra<Product>(EXTRA_ITEM)
        val resourceId = resources.getIdentifier(item.image, "drawable", packageName)
        itemImage.setImageResource(resourceId)
        itemName.text = item.title
        itemPrice.text = item.price


    }
}
