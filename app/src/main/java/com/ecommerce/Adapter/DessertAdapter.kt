package com.ecommerce.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.R
import com.ecommerce.model.DessertItem

class DessertAdapter(var con: Context, var originalList: ArrayList<DessertItem>) : RecyclerView.Adapter<DessertAdapter.ViewHolder>(), Filterable {
    var list: ArrayList<DessertItem> = originalList

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var img = v.findViewById<ImageView>(R.id.imgDessert)
        var tvName = v.findViewById<TextView>(R.id.txt_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.item_dessert, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(con).load(list[position].strMealThumb).into(holder.img)
        holder.tvName.text = list[position].strMeal
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val results = FilterResults()

                if (constraint.isNullOrEmpty()) {
                    results.values = originalList
                } else {
                    val filteredList = originalList.filter { dessert ->
                        dessert.strMeal?.contains(constraint, ignoreCase = true) == true
                    }
                    results.values = filteredList
                }

                return results
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                list = results?.values as ArrayList<DessertItem>
                notifyDataSetChanged()
            }
        }
    }
}