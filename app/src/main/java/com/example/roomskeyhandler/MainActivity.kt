package com.example.roomskeyhandler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.roomskeyhandler.Screens.MainScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tokenStore = TokenStore(applicationContext)
        val generalViewModel = ViewModelProvider(this, MyViewModelFactory(tokenStore))[GeneralViewModel::class.java]
        CoroutineScope(Dispatchers.IO).launch {
            if (tokenStore.getToken() != null) {
                generalViewModel.getProfile()
                generalViewModel.getMyKeys()
                generalViewModel.getUsers()
            }
        }
        setContent {
            val generalViewModel = ViewModelProvider(this, MyViewModelFactory(tokenStore))[GeneralViewModel::class.java]
            if (tokenStore.getToken() != null) {
                MainScreen()
//                ProfileScreen(generalViewModel)
            } else {
                MainScreen()
//                RegistrationScreen(generalViewModel)
//                LoginScreen(generalViewModel)
            }

//            RegistrationScreen(registrationViewModel)
        }
    }
}
