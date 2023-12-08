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
import com.ecommerce.model.CategoryItem

class CategoryAdapter(var con: Context, var list: ArrayList<CategoryItem>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var img = v.findViewById<ImageView>(R.id.imgCategory)
        var tvNameCategory = v.findViewById<TextView>(R.id.tvNameCategory)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemCategory: CategoryItem = list[position]
        Glide.with(con).load(list[position].strCategoryThumb).into(holder.img)
        holder.tvNameCategory.text = itemCategory.strCategory
    }


}