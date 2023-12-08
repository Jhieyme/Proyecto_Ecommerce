package com.ecommerce.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.Adapter.CategoryAdapter
import com.ecommerce.Adapter.PopularAdapter
import com.ecommerce.R
import com.ecommerce.data.ApiInterface
import com.ecommerce.data.ApiResponse
import com.ecommerce.data.RetrofitHelper
import com.ecommerce.model.CategoryItem
import com.ecommerce.model.DessertItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    lateinit var rvCategory: RecyclerView
    lateinit var rvPopular: RecyclerView
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var popularAdapter: PopularAdapter
    lateinit var apiInterface: ApiInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apiInterface = RetrofitHelper().getService()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        rvCategory = rootView.findViewById(R.id.rvCategory)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.layoutManager = layoutManager

        rvPopular = rootView.findViewById(R.id.rvDessertPopular)
        val gridLayoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        rvPopular.layoutManager = gridLayoutManager


        getCategories()

        getDessertPopular()

        return rootView
    }

    private fun getCategories() {
        val call = apiInterface.getCategories()
        call.enqueue(object : Callback<ApiResponse<CategoryItem>> {
            override fun onResponse(
                call: Call<ApiResponse<CategoryItem>>,
                response: Response<ApiResponse<CategoryItem>>
            ) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val categories = apiResponse?.categories
                    categoryAdapter = CategoryAdapter(requireActivity(), categories!!)
                    rvCategory.adapter = categoryAdapter

                }
            }

            override fun onFailure(call: Call<ApiResponse<CategoryItem>>, t: Throwable) {

            }


        })
    }

    private fun getDessertPopular() {
        val call = apiInterface.getDessert()
        call.enqueue(object : Callback<ApiResponse<DessertItem>> {
            override fun onResponse(
                call: Call<ApiResponse<DessertItem>>,
                response: Response<ApiResponse<DessertItem>>
            ) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val dessert = apiResponse?.meals
                    popularAdapter = PopularAdapter(requireActivity(), dessert!!)
                    rvPopular.adapter = popularAdapter
                }
            }

            override fun onFailure(call: Call<ApiResponse<DessertItem>>, t: Throwable) {

            }
        })
    }


}