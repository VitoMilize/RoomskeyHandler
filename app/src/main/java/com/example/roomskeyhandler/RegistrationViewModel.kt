package com.example.roomskeyhandler

import androidx.lifecycle.ViewModel
import com.example.roomskeyhandler.models.RegistrationRequest
import com.example.roomskeyhandler.models.RegistrationResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegistrationViewModel: ViewModel() {
    private val _nameText = MutableStateFlow("")
    val nameText = _nameText.asStateFlow()
    private val _phoneText = MutableStateFlow("")
    val phoneText = _phoneText.asStateFlow()
    private val _passwordText = MutableStateFlow("")
    val passwordText = _passwordText.asStateFlow()
    private val _passwordRepeatText = MutableStateFlow("")
    val passwordRepeatText = _passwordRepeatText.asStateFlow()
    private val _registrationResponse = MutableStateFlow<RegistrationResponse?>(null)
    val registrationResponse = _registrationResponse.asStateFlow()

    fun onNameChange(text: String) {
        _nameText.value = text
    }

    fun onPhoneChange(text: String) {
        _phoneText.value = text
    }
    fun onPasswordChange(text: String) {
        _passwordText.value = text
    }

    fun onPasswordRepeatChange(text: String) {
        _passwordRepeatText.value = text
    }



    suspend fun onRegistrationClick() {
        _registrationResponse.value = registration(
            RegistrationRequest(
                name = nameText.value,
                phone = phoneText.value,
                password = passwordText.value
            )
        )
    }

    private suspend fun registration(registrationRequest: RegistrationRequest): RegistrationResponse {
        return RetrofitClient.keysAPIService.registration(registrationRequest)
    }
}