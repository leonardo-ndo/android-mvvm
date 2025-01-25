package br.com.lno.androidmvvm.di

import br.com.lno.androidmvvm.data.retrofit.ToDoAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()
    )
        .build()

    @Provides
    fun provideToDoApi(retrofit: Retrofit): ToDoAPI = retrofit.create(ToDoAPI::class.java)
}