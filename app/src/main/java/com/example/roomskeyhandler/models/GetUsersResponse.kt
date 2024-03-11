package com.example.roomskeyhandler.models

data class GetUsersResponse(
    val pagination: Pagination,
    val users: List<User>
)