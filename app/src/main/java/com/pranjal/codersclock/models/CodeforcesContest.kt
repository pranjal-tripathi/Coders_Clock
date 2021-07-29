package com.pranjal.codersclock.models

data class CodeforcesContest(
    val durationSeconds: Int,
    val frozen: Boolean,
    val id: Int,
    val name: String,
    val phase: String,
    val relativeTimeSeconds: Int,
    val startTimeSeconds: Int,
    val type: String
)