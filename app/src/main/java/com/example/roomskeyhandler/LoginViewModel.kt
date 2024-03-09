package com.example.roomskeyhandler

import androidx.lifecycle.ViewModel
import com.example.roomskeyhandler.models.LoginRequest
import com.example.roomskeyhandler.models.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel: ViewModel() {
    private val _phoneText = MutableStateFlow("")
    val phoneText = _phoneText.asStateFlow()
    private val _passwordText = MutableStateFlow("")
    val passwordText = _passwordText.asStateFlow()
    private val _loginResponse = MutableStateFlow<LoginResponse?>(null)
    val loginResponse = _loginResponse.asStateFlow()
    fun onPhoneChange(text: String) {
        _phoneText.value = text
    }
    fun onPasswordChange(text: String) {
        _passwordText.value = text
    }

    suspend fun onLoginClick() {
        _loginResponse.value = login(
            LoginRequest(
                phone = phoneText.value,
                password = passwordText.value
            )
        )
    }

    private suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return RetrofitClient.keysAPIService.login(loginRequest)
    }
}