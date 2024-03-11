package com.example.roomskeyhandler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.roomskeyhandler.Screens.LoginScreen
import com.example.roomskeyhandler.Screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tokenStore = TokenStore(applicationContext)
        val generalViewModel = ViewModelProvider(this, MyViewModelFactory(tokenStore))[GeneralViewModel::class.java]
        if (tokenStore.getToken() != null) {
            generalViewModel.getProfile()
            generalViewModel.getMyKeys()
            generalViewModel.getUsers()
        }
        setContent {
            if (tokenStore.getToken() != null) {
                MainScreen(generalViewModel)
//                ProfileScreen(generalViewModel)
            } else {
                LoginScreen(generalViewModel)
            }

//            RegistrationScreen(registrationViewModel)
        }
    }
}
