package com.fedi.apiaplicatiion1
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {

    @GET("users/listeragent") // replace with your actual endpoint
    fun getUserDetails(@Header("Authorization") token: String): Call<LoginResult>

    @GET("afficherplanning/{id}")
    suspend fun getPlanningById(@Path("id") id: String): Planning

    @GET("afficherplannig")
    fun getAllPlanning(): Call<List<Planning>>
}