package com.example.jcmotion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jcmotion.model.CatFact
import com.example.jcmotion.network.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CatFactViewModel : ViewModel() {
    private val _catFact = MutableStateFlow<CatFact?>(null)
    val catFact: StateFlow<CatFact?> = _catFact

    fun fetchCatFact() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getCatFact()
                _catFact.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
