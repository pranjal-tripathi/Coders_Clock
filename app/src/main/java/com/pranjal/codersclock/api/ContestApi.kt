package com.pranjal.codersclock.api

import com.pranjal.codersclock.models.Contest
import retrofit2.Response
import retrofit2.http.GET

interface ContestApi {

    @GET("/api/v1/all")
    suspend fun getAllContests(): Response<List<Contest>>

    @GET("/api/v1/codeforces")
    suspend fun getCodeforcesContest(): Response<List<Contest>>

    @GET("/api/v1/top_coder")
    suspend fun getTopCoderContest(): Response<List<Contest>>

    @GET("/api/v1/at_coder")
    suspend fun getAtCoderContest(): Response<List<Contest>>

    @GET("/api/v1/code_chef")
    suspend fun getCodeChefContest(): Response<List<Contest>>

    @GET("api/v1/hacker_rank")
    suspend fun getHackerRankContest(): Response<List<Contest>>

    @GET("/api/v1/hacker_earth")
    suspend fun getHackerEarthContest(): Response<List<Contest>>

    @GET("/api/v1/kick_start")
    suspend fun getKickStartContest(): Response<List<Contest>>

    @GET("/api/v1/leet_code")
    suspend fun getLeetCodeContest(): Response<List<Contest>>

}