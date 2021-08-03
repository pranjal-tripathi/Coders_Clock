package com.pranjal.codersclock.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val codeforcesApi: ContestApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://codeforces.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ContestApi::class.java)
    }

    val hackerEarthApi: ContestApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.hackerearth.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ContestApi::class.java)
    }

    val hackerRankApi: ContestApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.hackerrank.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ContestApi::class.java)
    }

    val leetCodeApi: ContestApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://leetcode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ContestApi::class.java)
    }
}