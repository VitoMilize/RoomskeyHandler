package com.example.roomskeyhandler.models

data class RegistrationResponse(
    val message: String,
    val token: String
) {
    constructor(message: String) : this(message, "")
}