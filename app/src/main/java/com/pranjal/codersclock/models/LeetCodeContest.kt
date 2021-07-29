package com.pranjal.codersclock.models

data class LeetCodeContest(
    val description: String,
    val discuss_topic_id: Any,
    val duration: Int,
    val id: Int,
    val is_private: Boolean,
    val is_virtual: Boolean,
    val origin_start_time: Int,
    val start_time: Int,
    val title: String,
    val title_slug: String
)