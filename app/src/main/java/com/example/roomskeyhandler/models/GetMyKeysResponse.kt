package com.example.roomskeyhandler.models

data class GetMyKeysResponse(
    val keys: List<Key>?,
    val pagination: Pagination
)