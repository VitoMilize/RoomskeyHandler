package com.example.roomskeyhandler.models

data class ChangeProfileRequest(
    val avatarLink: String,
    val email: String,
    val name: String,
    val phone: String
)