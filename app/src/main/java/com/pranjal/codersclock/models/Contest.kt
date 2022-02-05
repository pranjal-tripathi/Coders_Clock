package com.pranjal.codersclock.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Contest(
    @SerializedName("name"        ) var name      : String?,
    @SerializedName("url"         ) var url       : String?,
    @SerializedName("start_time"  ) var startTime : String?,
    @SerializedName("end_time"    ) var endTime   : String?,
    @SerializedName("duration"    ) var duration  : String?,
    @SerializedName("in_24_hours" ) var in24Hours : String?,
    @SerializedName("status"      ) var status    : String?,
    val reminder: Boolean
    )