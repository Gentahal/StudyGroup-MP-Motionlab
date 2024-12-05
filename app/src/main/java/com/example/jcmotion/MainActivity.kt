package com.example.jcmotion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.jcmotion.feature.BookDetailScreen
import com.example.jcmotion.ui.theme.JcMotionTheme
import com.example.jcmotion.feature.HomeScreen
import com.example.jcmotion.feature.LoginScreen
import com.example.jcmotion.feature.MainScreen
import com.example.jcmotion.feature.ProfileScreen
import com.example.jcmotion.feature.RegisterScreen
import com.example.jcmotion.feature.SettingsScreen
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JcMotionTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = LoginScreen,
                ){
                    composable<LoginScreen> {
                        LoginScreen(navController)
                    }
                    composable<MainScreen> {
                        MainScreen(navController)
                    }
                    composable<HomeScreen> {
                        HomeScreen(navController)
                    }
                    composable<ProfileScreen> {
                        ProfileScreen(navController)
                    }
                    composable<RegisterScreen> {
                        RegisterScreen(navController)
                    }
                    composable<SettingsScreen> {
                        SettingsScreen(navController)
                    }
                    composable<BookDetail> {
                        val args = it.toRoute<BookDetail>()
                        BookDetailScreen(args)
                    }
                }

            }
        }
    }
}

@Serializable
object MainScreen

@Serializable
object LoginScreen

@Serializable
object HomeScreen

@Serializable
object ProfileScreen

@Serializable
object RegisterScreen

@Serializable
object SettingsScreen

@Serializable
data class BookDetail(val bookTitle : String, val bookDesc : String)


