package com.example.wishlist_app

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import org.apache.commons.io.FileUtils;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var mItem: List<ClipData.Item>
    var myWishes: ArrayList<Wish>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val subButton = findViewById<Button>(R.id.button)
        val nameInput = findViewById<EditText>(R.id.Item)
        val siteInput = findViewById<EditText>(R.id.URL)
        val priceInput = findViewById<EditText>(R.id.Price)
        
        val name = nameInput.text.toString()
        val url = siteInput.text.toString()
        val price = priceInput.text.toString()
        
        myWishes = ArrayList()
        subButton.setOnClickListener {
            myWishes.add(Wish(name, url, price))
        }
        
        val wishList = findViewById<RecyclerView>(R.id.itemRV)
        
        val adapter = ItemAdapter(myWishes)
        
        wishList.adapter = adapter
        wishList.layoutManager = LinearLayoutManager(this)
    }
}
