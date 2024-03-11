package com.example.roomskeyhandler

import com.example.roomskeyhandler.models.ChangeProfileRequest
import com.example.roomskeyhandler.models.ChangeProfileResponse
import com.example.roomskeyhandler.models.GetMyKeysResponse
import com.example.roomskeyhandler.models.GetUsersResponse
import com.example.roomskeyhandler.models.GiveKeyRequest
import com.example.roomskeyhandler.models.GiveKeyResponse
import com.example.roomskeyhandler.models.LoginRequest
import com.example.roomskeyhandler.models.LoginResponse
import com.example.roomskeyhandler.models.LogoutResponse
import com.example.roomskeyhandler.models.ProfileResponse
import com.example.roomskeyhandler.models.RegistrationRequest
import com.example.roomskeyhandler.models.RegistrationResponse
import com.example.roomskeyhandler.models.ScheduleBlockResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface KeysAPIService {
    @POST("api/user/register")
    suspend fun registration(@Body registrationRequest: RegistrationRequest): Response<RegistrationResponse>

    @POST("api/user/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @DELETE("api/user/logout")
    suspend fun logout(@Header("Authorization") token: String): Response<LogoutResponse>

    @PUT("api/user/profile/update")
    suspend fun changeProfile(@Body changeProfileRequest: ChangeProfileRequest, @Header("Authorization") token: String): Response<ChangeProfileResponse>

    @GET("api/user/profile")
    suspend fun getProfile(@Header("Authorization") token: String): Response<ProfileResponse>

    @GET("api/getMyKeys")
    suspend fun getMyKeys(@Header("Authorization") token: String, @Query("size") size: Int): Response<GetMyKeysResponse>

    @POST("api/giveKey")
    suspend fun giveKey(@Header("Authorization") token: String, @Query("id") id: Int, @Body giveKeyRequest: GiveKeyRequest): Response<GiveKeyResponse>

    @GET("api/user")
    suspend fun getUsers(@Header("Authorization") token: String, @Query("size") size: Int): Response<GetUsersResponse>

    @GET("api/bid/forVitya")
    suspend fun getScheduleBlock(@Header("Authorization") token: String, @Query("time") time: String, @Query("date") date: String): Response<ScheduleBlockResponse>
}