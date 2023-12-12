package com.ecommerce.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ecommerce.R
import com.ecommerce.databinding.FragmentDetailBinding
import com.ecommerce.model.DessertEntity
import com.ecommerce.model.DessertItem


class DetailFragment : Fragment() {

    lateinit var dessertItem: DessertItem
    private lateinit var binding: FragmentDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.textViewProductName.text = dessertItem.strMeal
        Glide.with(this).load(dessertItem.strMealThumb).into(binding.imageViewProduct)


        val itemDB =
            DessertEntity(dessertItem.idMeal, dessertItem.strMeal, dessertItem.strMealThumb)


        binding.btnFavorito.setOnClickListener {


        }

        binding.btnBack.setOnClickListener(View.OnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fcv_main, DessertFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        })



        return binding.root
    }


    fun onItemClick() {
        val bundle = arguments
        if (bundle != null) {
            dessertItem = (bundle.getSerializable("item") as? DessertItem)!!
        }
    }


}