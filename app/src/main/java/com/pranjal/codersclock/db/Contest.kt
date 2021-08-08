package com.pranjal.codersclock.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contest")
data class Contest(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "contest_name") val contestName: String,
    @ColumnInfo(name = "start_time") val startTime: Long,
    @ColumnInfo(name = "end_time") val endTime: Long,
    @ColumnInfo(name = "duration") val duration: Long,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "reminder") val reminder: String
)
