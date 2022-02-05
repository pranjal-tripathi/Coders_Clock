package com.pranjal.codersclock.utils

import com.pranjal.codersclock.db.Contest
import java.util.*

object ContestDbToContestViewConverter {

    fun convertToView(contests: List<Contest>) : List<com.pranjal.codersclock.models.Contest> {
        var contestViews: MutableList<com.pranjal.codersclock.models.Contest> = mutableListOf()
//        for (contest in contests) {
//            var startDateTime = Date(contest.startTime).toString()
//            var minute = contest.duration/60000
//            var hour = minute/60L
//            minute = minute%60L
//            var duration = "$hour H : $minute M"
//            var reminder = contest.reminder.equals("true", ignoreCase = true)
//            var contestView = com.pranjal.codersclock.models.Contest(
//                contest.contestName,
//                startDateTime,
//                duration,
//                contest.url,
//                reminder
//            )
//            contestViews.add(contestView)
//        }
        return contestViews
    }
}