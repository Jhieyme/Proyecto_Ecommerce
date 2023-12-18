package com.ecommerce.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ecommerce.model.DessertItem

class DessertViewModel : ViewModel() {


    private val _listDessert = MutableLiveData<List<DessertItem>>()
    val listDessert: LiveData<List<DessertItem>> get() = _listDessert


    fun addDessertVM(item: DessertItem) {
        val currentList = _listDessert.value.orEmpty().toMutableList()
        currentList.add(item)
        _listDessert.value = currentList
        println((_listDessert.value as MutableList<DessertItem>).size)
    }
}