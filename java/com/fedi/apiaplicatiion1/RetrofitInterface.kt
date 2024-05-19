package com.fedi.apiaplicatiion1
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*

interface RetrofitInterface {
    @POST("users/signin")
    fun executeLogin(@Body map: HashMap<String, String>): Call<LoginResult>

    @POST("users/signup")
    fun executeSignup(@Body map: HashMap<String, String>): Call<Void>

    @POST("users/permission")
    fun executePermission(@Body map: HashMap<String, String>): Call<Void>
}