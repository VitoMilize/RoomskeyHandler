package com.example.roomskeyhandler.models

data class RegistrationRequest(
    val name: String,
    val password: String,
    val phone: String
)