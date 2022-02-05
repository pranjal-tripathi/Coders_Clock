package com.pranjal.codersclock.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val contestApi: ContestApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.kontests.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ContestApi::class.java)
    }

}