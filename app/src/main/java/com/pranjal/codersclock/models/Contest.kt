package com.pranjal.codersclock.models

import java.util.*

data class Contest(
    val contestName: String,
    val startTime: String,
    val duration: String,
    val url: String,
    val reminder: Boolean
    )