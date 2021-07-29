package com.pranjal.codersclock.models

data class HackerEarthContest(
    val challenge_type: String,
    val college: Boolean,
    val cover_image: String,
    val date: String,
    val description: String,
    val end_date: String,
    val end_time: String,
    val end_timestamp: String,
    val end_tz: String,
    val end_utc_tz: String,
    val is_hackerearth: Boolean,
    val start_timestamp: String,
    val start_tz: String,
    val start_utc_tz: String,
    val status: String,
    val subscribe: String,
    val thumbnail: String,
    val time: String,
    val title: String,
    val url: String
)