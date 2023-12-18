package com.ecommerce.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.R
import com.ecommerce.model.DessertItem

class CartAdapter(var con: Context, var originalList: List<DessertItem>) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var imgCartItem = v.findViewById<ImageView>(R.id.imgCart)
        var tvNameCart = v.findViewById<TextView>(R.id.tvNameCart)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return originalList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartItem: DessertItem = originalList[position]
        Glide.with(con).load(cartItem.strMealThumb).into(holder.imgCartItem)
        holder.tvNameCart.text = cartItem.strMeal
    }
}