package com.pranjal.codersclock.api

import com.pranjal.codersclock.models.*
import retrofit2.Response
import retrofit2.http.GET

interface ContestApi {

    @GET("/chrome-extension/events/")
    suspend fun getHackerRankContest(): Response<RawResponse>

    @GET("/api/contest.list")
    suspend fun getCodeforcesContest(): Response<RawResponse>

    @GET("/rest/contests/upcoming?limit=20")
    suspend fun getHackerRankGeneralContest(): Response<RawResponse>

    @GET("/rest/contests/college?limit=20")
    suspend fun getHackerRankCollegeContest(): Response<RawResponse>

    @GET("/contest/api/list/")
    suspend fun getLeetCodeContest(): Response<RawResponse>
}