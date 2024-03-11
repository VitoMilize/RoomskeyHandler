package com.example.roomskeyhandler.models

data class ProfileResponse(
    val avatarLink: String?,
    val email: String?,
    val name: String,
    val phone: String,
    val role: String
)