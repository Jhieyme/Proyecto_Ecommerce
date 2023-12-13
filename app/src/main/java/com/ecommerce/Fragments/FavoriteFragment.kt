package com.ecommerce.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.Adapter.FavoriteAdapter
import com.ecommerce.databinding.FragmentFavoritesBinding
import com.ecommerce.model.DessertEntity
import com.ecommerce.database.AppDataBase
import com.ecommerce.database.HandlerDB

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val favoriteList: List<DessertEntity> = obtenerFavoritosDesdeBaseDeDatos()

        favoriteAdapter = FavoriteAdapter(favoriteList)
        val gridLayoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.rvFavoritos.layoutManager = gridLayoutManager

        binding.rvFavoritos.adapter = favoriteAdapter
    }

    private fun obtenerFavoritosDesdeBaseDeDatos(): List<DessertEntity> {
        // Lógica para obtener la lista de favoritos de la BD
        val database: AppDataBase = HandlerDB.getInstance(requireContext())
        return database.dessertDAO().getAllFavorites()
    }
}