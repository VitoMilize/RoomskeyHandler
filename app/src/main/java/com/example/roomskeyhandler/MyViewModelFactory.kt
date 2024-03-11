package com.example.roomskeyhandler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MyViewModelFactory(private val tokenStore: TokenStore) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return when (modelClass) {
            GeneralViewModel::class.java -> GeneralViewModel(tokenStore) as T
            else -> null as T
        }
    }
}