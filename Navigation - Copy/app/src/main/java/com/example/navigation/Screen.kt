package com.example.navigation

sealed class Screen(val route:String) {
    object Login:Screen(route = "login_screen")
    object Register:Screen(route = "register_screen")
}