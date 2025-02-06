package com.example.jcmotion.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jcmotion.data.FavoriteLocation
import com.example.jcmotion.data.WeatherResponse
import com.example.jcmotion.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {
    private val _weatherData = MutableStateFlow<WeatherResponse?>(null)
    val weatherData: StateFlow<WeatherResponse?> = _weatherData

    private val _favorites = MutableStateFlow<List<FavoriteLocation>>(emptyList())
    val favorites: StateFlow<List<FavoriteLocation>> = _favorites

    init {
        loadFavorites()
    }

    fun loadWeather(cityName: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = repository.getWeather(cityName, apiKey)
                _weatherData.value = response
            } catch (e: Exception) {
                _weatherData.value = null
            }
        }
    }

    fun addFavorite(favorite: FavoriteLocation) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFavorite(favorite)
            loadFavorites() // Update daftar favorit setelah menambahkan
        }
    }

    fun loadFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            _favorites.value = repository.getAllFavorites()
        }
    }

    fun removeFavorite(favorite: FavoriteLocation) {
        viewModelScope.launch {
            repository.removeFavorite(favorite)
            _favorites.value = repository.getAllFavorites()
        }
    }
}