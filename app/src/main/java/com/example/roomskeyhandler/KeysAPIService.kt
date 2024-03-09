package com.example.roomskeyhandler

import com.example.roomskeyhandler.models.LoginRequest
import com.example.roomskeyhandler.models.LoginResponse
import com.example.roomskeyhandler.models.RegistrationRequest
import com.example.roomskeyhandler.models.RegistrationResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Headers
import retrofit2.http.POST

interface KeysAPIService {
    @POST("/user/register")
    suspend fun registration(@Body registrationRequest: RegistrationRequest): RegistrationResponse

    @POST("/user/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @DELETE("/user/logout")
    @Headers("Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNjQ2OTUyNzk3LCJleHAiOjE2NDY5NTczOTd9.sXq_Zt47pUaD-7s8o-838383838383838383838383838383838383838383838383")
    suspend fun logout() {
        // ... Logout logic goes here ...
    }
}