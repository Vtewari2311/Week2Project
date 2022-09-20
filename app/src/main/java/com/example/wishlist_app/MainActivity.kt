package com.example.wishlist_app

import android.content.ClipData
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.List


class MainActivity : AppCompatActivity() {
    //var adapter: MyRecyclerViewAdapter? = null
    lateinit var items: List<ClipData.Item>
    lateinit var myWishes: ArrayList<Wish>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton= findViewById<Button>(R.id.Button)
        val item = findViewById<EditText>(R.id.item)
        val url = findViewById<EditText>(R.id.url)
        val price = findViewById<EditText>(R.id.price)

        val userItem = item.text.toString()
        val userPrice = url.text.toString()
        val userURL = price.text.toString()
        
        myWishes = ArrayList()
        submitButton.setOnClickListener {
            myWishes.add(Wish(userItem, userPrice, userURL))
        }
        // Lookup the RecycleViewer in activity layout
        val recycleViewer = findViewById<RecyclerView>(R.id.itemRV)
        // Create adapter passing in the list of items
        val adapter = MyRecyclerViewAdapter(myWishes)
        // Attach the adapter to the RecycleViewer to populate items
        recycleViewer.adapter = adapter
        // Set layout manager to position the items
        recycleViewer.layoutManager = LinearLayoutManager(this)

        //override fun onItemClick(View: view, Int: position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        //}
    }
}
