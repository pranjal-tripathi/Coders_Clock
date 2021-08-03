package com.pranjal.codersclock.api

import com.pranjal.codersclock.models.*
import retrofit2.Response
import retrofit2.http.GET

interface ContestApi {

    @GET("/chrome-extension/events/")
    suspend fun getHackerRankContest(): Response<List<HackerEarthContest>>

    @GET("/api/contest.list")
    suspend fun getCodeforcesContest(): Response<ResponseRe>

    @GET("/rest/contests/upcoming?limit=20")
    suspend fun getHackerRankGeneralContest(): Response<List<HackerRankGeneralContest>>

    @GET("/rest/contests/college?limit=20")
    suspend fun getHackerRankCollegeContest(): Response<List<HackerRankCollegeContest>>

    @GET("/contest/api/list/")
    suspend fun getLeetCodeContest(): Response<List<LeetCodeContest>>
}