package com.example.wishlist_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter (private val mItems: List<Wish>, private var mClickListener: ItemClickListener? = null) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {
    // stores and recycles views as they are scrolled off screen

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        val itemTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView
        //fun onClick(view: android.view.View){
        //    if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        //}

        init {
            // Stores the itemView in a public final member variable that can be used to access
            // the context from any ViewHolder instance
            itemTextView = itemView.findViewById(com.example.wishlist_app.R.id.item)
            priceTextView = itemView.findViewById(com.example.wishlist_app.R.id.price)
            urlTextView = itemView.findViewById(com.example.wishlist_app.R.id.url)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_list, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model on position
        val wish = mItems[position]
        // Set item views based on views and data model
        holder.itemTextView.text = wish.item
        holder.priceTextView.text = wish.price
        holder.urlTextView.text = wish.url
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    //convenience method for getting data at click position
    fun getItem(id: Int): Wish {
        return mItems[id]
    }

    // allows clicks events to be caught
    //fun setClickListener(itemClickListener: MyRecyclerViewAdapter.ItemClickListener?){
    // this.mClickListener = itemClickListener
    //}
    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: android.view.View?, position: kotlin.Int)
    }
}
