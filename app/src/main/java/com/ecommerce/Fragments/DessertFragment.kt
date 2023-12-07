package com.ecommerce.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.Adapter.DessertAdapter
import com.ecommerce.R
import com.ecommerce.data.ApiInterface
import com.ecommerce.data.ApiResponse
import com.ecommerce.data.RetrofitHelper
import com.ecommerce.model.DessertItem
import androidx.appcompat.widget.SearchView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DessertFragment : Fragment() {

    lateinit var rvDessert : RecyclerView
    lateinit var dessertAdapter: DessertAdapter
    lateinit var apiInterface : ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apiInterface = RetrofitHelper().getService()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_dessert, container, false)

        rvDessert = rootView.findViewById(R.id.rv_dessert)
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvDessert.layoutManager = layoutManager

        val searchView = rootView.findViewById<SearchView>(R.id.sv_searchPostre)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Filtrar postre según el texto
                dessertAdapter.filter.filter(newText)
                return true
            }
        })

        getDessert()

        return rootView
    }

    private fun getDessert(){
        val call = apiInterface.getDessert()
        call.enqueue(object : Callback<ApiResponse<DessertItem>>{
            override fun onResponse(
                call: Call<ApiResponse<DessertItem>>,
                response: Response<ApiResponse<DessertItem>>
            ) {
                if(response.isSuccessful){
                    val apiResponse = response.body()
                    val dessert = apiResponse?.meals
                    dessertAdapter = DessertAdapter(requireActivity(), dessert!!)
                    rvDessert.adapter = dessertAdapter
                }
            }

            override fun onFailure(call: Call<ApiResponse<DessertItem>>, t: Throwable) {

            }
        })
    }


}