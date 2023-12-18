package com.ecommerce.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.Adapter.CartAdapter
import com.ecommerce.R
import com.ecommerce.databinding.FragmentCartBinding
import com.ecommerce.model.DessertItem
import com.ecommerce.viewmodel.DessertViewModel


class CartFragment : Fragment() {


    private lateinit var binding: FragmentCartBinding
    private val dessertVM: DessertViewModel by activityViewModels()


    private lateinit var cartAdapter: CartAdapter
    private lateinit var rvItemsCart: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)


        rvItemsCart = binding.root.findViewById(R.id.rvCartItems)
        val linearLayout = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvItemsCart.layoutManager = linearLayout







        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dessertVM.listDessert.observe(viewLifecycleOwner) { items ->
            println(items)
            val listItems: List<DessertItem> = items
            cartAdapter = CartAdapter(requireActivity(), listItems)
            rvItemsCart.adapter = cartAdapter
        }
    }


}