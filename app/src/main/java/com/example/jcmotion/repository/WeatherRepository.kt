package com.example.jcmotion.repository

import com.example.jcmotion.data.FavoriteLocation
import com.example.jcmotion.data.WeatherResponse
import com.example.jcmotion.network.RetrofitInstance
import com.example.jcmotion.database.FavoriteDao

class WeatherRepository(private val favoriteDao: FavoriteDao) {
    private val weatherApi = RetrofitInstance.weatherApi

    suspend fun getWeather(cityName: String, apiKey: String): WeatherResponse {
        return weatherApi.getWeather(cityName, apiKey)
    }

    suspend fun addFavorite(favorite: FavoriteLocation) {
        favoriteDao.addFavorite(favorite)
    }

    suspend fun removeFavorite(favorite: FavoriteLocation) {
        favoriteDao.removeFavorite(favorite)
    }

    suspend fun getAllFavorites(): List<FavoriteLocation> {
        return favoriteDao.getAllFavorites()
    }
}