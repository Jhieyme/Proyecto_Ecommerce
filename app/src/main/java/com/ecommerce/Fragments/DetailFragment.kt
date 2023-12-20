package com.ecommerce.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.ecommerce.R
import com.ecommerce.database.HandlerDB
import com.ecommerce.databinding.FragmentDetailBinding
import com.ecommerce.model.DessertEntity
import com.ecommerce.model.DessertItem
import com.ecommerce.viewmodel.DessertViewModel


class DetailFragment : Fragment() {

    lateinit var dessertItem: DessertItem
    private lateinit var binding: FragmentDetailBinding


    private val dessertVM: DessertViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.textViewProductName.text = dessertItem.strMeal
        Glide.with(this).load(dessertItem.strMealThumb).into(binding.imageViewProduct)
        var fragmentManager = requireActivity().supportFragmentManager
        binding.btnFavorito.setOnClickListener {
            val dessertEntity = DessertEntity(
                dessertItem.idMeal ?: "1",
                dessertItem.strMeal,
                dessertItem.strMealThumb
            )

            val database = HandlerDB.getInstance(requireContext())
            database.dessertDAO().addDessertDAO(dessertEntity)
        }

        binding.btnBack.setOnClickListener(View.OnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fcv_main, DessertFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        })

        binding.btnAdd.setOnClickListener {
            dessertVM.addDessertVM(dessertItem)
            Toast.makeText(context, "¡Agregaste un producto!", Toast.LENGTH_SHORT).show()
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fcv_main, CartFragment())
            fragmentTransaction.commit()
        }




        return binding.root
    }


    fun onItemClick() {
        val bundle = arguments
        if (bundle != null) {
            dessertItem = (bundle.getSerializable("item") as? DessertItem)!!
        }
    }


}