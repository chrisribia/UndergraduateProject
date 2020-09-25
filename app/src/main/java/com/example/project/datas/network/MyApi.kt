package com.example.project.datas.network

import com.example.project.datas.network.responses.AuthResponse
import com.example.project.datas.network.responses.DebtorsResponse
import com.example.project.datas.network.responses.LoginResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @GET("getDebtors.php")
    suspend fun getDebtors(): Response<DebtorsResponse>


    @FormUrlEncoded
    @POST("userLogin.php")
    suspend fun userLogin(
        @Field("username") username: String,
        @Field("password") password: String
    ) : Response<LoginResponse>


    @FormUrlEncoded
    @POST("userRegistration.php")
    suspend fun userSignup(
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("password") password: String
    ) : Response<AuthResponse>
    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : MyApi {

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("http://192.168.43.98/hunproject/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}