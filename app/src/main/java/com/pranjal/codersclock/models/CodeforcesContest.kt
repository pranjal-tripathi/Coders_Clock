package com.pranjal.codersclock.models

data class CodeforcesContest(
    val durationSeconds: Long,
    val frozen: Boolean,
    val id: Int,
    val name: String,
    val phase: String,
    val relativeTimeSeconds: Long,
    val startTimeSeconds: Long,
    val type: String
)