package com.example.jcmotion.feature

import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.jcmotion.data.FavoriteLocation
import com.example.jcmotion.database.AppDatabase
import com.example.jcmotion.model.WeatherViewModel
import com.example.jcmotion.model.WeatherViewModelFactory
import com.example.jcmotion.repository.WeatherRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(navController: NavController, viewModel: WeatherViewModel = viewModel(
    factory = WeatherViewModelFactory(
        repository = WeatherRepository(
            favoriteDao = AppDatabase.getDatabase(LocalContext.current).favoriteDao()
        )
    )
)) {
    val weatherData by viewModel.weatherData.collectAsState()
    val favorites by viewModel.favorites.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color(0xFFF4F4F4))) {

        // Input kota
        var cityName by remember { mutableStateOf("") }
        TextField(
            value = cityName,
            onValueChange = { cityName = it },
            label = { Text("Masukkan nama kota", color = MaterialTheme.colorScheme.primary) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary
            )
        )

        // Tombol Cari Cuaca
        Button(
            onClick = {
                val apiKey = "4beedf519c8ca044bcdbfec1e8070b5a" // Ganti dengan API key Anda
                viewModel.loadWeather(cityName, apiKey)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text("Cari Cuaca", color = Color.White)
        }

        // Tampilkan data cuaca
        weatherData?.let { data ->
            Spacer(modifier = Modifier.height(16.dp))
            Text("Cuaca di ${data.name}", style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold))
            Text("Suhu: ${data.main.temp}°C", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    val favorite = FavoriteLocation(
                        id = data.name,
                        name = data.name,
                        temperature = data.main.temp
                    )
                    viewModel.addFavorite(favorite)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text("Tambahkan ke Favorit", color = Color.White)
            }
        }

        // Tampilkan daftar favorit
        Spacer(modifier = Modifier.height(32.dp))
        Text("Lokasi Favorit", style = MaterialTheme.typography.headlineSmall)
        LazyColumn {
            items(favorites) { favorite ->
                FavoriteItem(favorite, onDelete = {
                    viewModel.removeFavorite(favorite)
                })
            }
        }
    }
}

@Composable
fun FavoriteItem(favorite: FavoriteLocation, onDelete: () -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = favorite.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Suhu: ${favorite.temperature}°C", style = MaterialTheme.typography.bodyMedium)
            Button(onClick = onDelete) {
                Text("Hapus dari Favorit")
            }
        }
    }
}