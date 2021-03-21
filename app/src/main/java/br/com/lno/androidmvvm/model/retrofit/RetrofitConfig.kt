package br.com.lno.androidmvvm.model.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

}