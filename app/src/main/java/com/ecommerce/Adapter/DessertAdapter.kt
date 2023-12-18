package com.ecommerce.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.Fragments.DetailFragment
import com.ecommerce.R
import com.ecommerce.model.DessertItem

class DessertAdapter(
    var con: Context,
    var originalList: ArrayList<DessertItem>,
    private val detailFragment: DetailFragment
) :
    RecyclerView.Adapter<DessertAdapter.ViewHolder>(), Filterable {
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

        val dessertItem: DessertItem = list[position]
        Glide.with(con).load(dessertItem.strMealThumb).into(holder.img)
        holder.tvName.text = dessertItem.strMeal

        holder.itemView.setOnClickListener(View.OnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val data = dessertItem

                val bundle = Bundle().apply {
                    putSerializable("item", data)
                }


                val detailFragment = DetailFragment()

                detailFragment.arguments = bundle
                detailFragment.onItemClick()

                val fragmentManager =
                    (holder.itemView.context as AppCompatActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.fcv_main, detailFragment)
                    .commit()
            }
        })


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