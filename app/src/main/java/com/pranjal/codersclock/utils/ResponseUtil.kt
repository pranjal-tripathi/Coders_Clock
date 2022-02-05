package com.pranjal.codersclock.utils

import com.pranjal.codersclock.models.Contest
import java.lang.Exception
import java.text.SimpleDateFormat

object ResponseUtil {

    fun getContests(response: List<Contest>) : List<Contest> {
        var contests: MutableList<Contest> = mutableListOf()
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        for(contest in response) {
            try {
                contest.startTime = format.parse(contest.startTime).toString()
                contest.endTime = format.parse(contest.endTime).toString()
            } catch(e : Exception) {
                contest.startTime = contest.startTime
                contest.endTime = contest.endTime
            }
            contests.add(contest)
        }
        return contests
    }

    fun getRunningContests(response: List<Contest>) : List<Contest> {
        var contests: MutableList<Contest> = mutableListOf()
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        for(contest in response) {
            try {
                contest.startTime = format.parse(contest.startTime).toString()
                contest.endTime = format.parse(contest.endTime).toString()
            } catch(e : Exception) {
                contest.startTime = contest.startTime
                contest.endTime = contest.endTime
            }
            if(contest.status == "CODING")
                contests.add(contest)
        }
        return contests
    }
}