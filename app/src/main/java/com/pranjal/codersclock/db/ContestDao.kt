package com.pranjal.codersclock.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContestDao {

    @Query("SELECT * FROM contest")
    fun getAll(): List<Contest>

    @Query("SELECT * FROM contest WHERE start_time > (:date) ORDER BY start_time DESC")
    fun getAllUpcoming(date: Long): List<Contest>

    @Query("SELECT * FROM contest WHERE reminder = (:reminder)")
    fun getAllByReminder(reminder: String): List<Contest>

    @Insert
    fun insertAll(vararg contest: Contest)

    @Delete
    fun delete(vararg contest: Contest)
}