package com.example.ghmobile

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitHubAPIServiceProvider {

    val baseURL : String = "https://api.github.com/"

    val gitHubAPIService : GitHubAPIService

    init {
        val client : OkHttpClient = OkHttpClient.Builder().build()
        gitHubAPIService = provideRetrofit(client)
    }

    private fun provideRetrofit(client: OkHttpClient): GitHubAPIService {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubAPIService::class.java)
    }
}