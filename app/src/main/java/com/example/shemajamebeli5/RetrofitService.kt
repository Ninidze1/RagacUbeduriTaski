package com.example.shemajamebeli5

import com.example.shemajamebeli5.interfaces.RetrofitRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitService {

    private const val BASE_URL = "https://run.mocky.io"

    fun retrofitService(): RetrofitRepository {
        return Retrofit.Builder().baseUrl(
            BASE_URL
        ).addConverterFactory(GsonConverterFactory.create()).build().create(RetrofitRepository::class.java)
    }

}