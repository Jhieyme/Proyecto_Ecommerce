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

class PopularAdapter(var con: Context, var originalList: ArrayList<DessertItem>) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var imgDessertPopular = v.findViewById<ImageView>(R.id.imgPopular)
        var tvNameDessert = v.findViewById<TextView>(R.id.tvPopularItem)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.item_popular, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return originalList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dessertItem: DessertItem = originalList[position]

        Glide.with(con).load(dessertItem.strMealThumb).into(holder.imgDessertPopular)
        holder.tvNameDessert.text = dessertItem.strMeal

    }

}
