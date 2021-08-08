package com.pranjal.codersclock.utils

import com.pranjal.codersclock.db.Contest
import com.pranjal.codersclock.models.CodeforcesContest
import com.pranjal.codersclock.models.RawResponse

object ResponseHandler {

    fun handleRawResponse(response: RawResponse) = response.result

    fun handleCodeforcesResponse(response: List<CodeforcesContest>) : List<Contest> {
        var contests: MutableList<Contest> = mutableListOf()
        for(cfContest in response) {
            var contest = Contest(
                0,
                cfContest.name,
                cfContest.startTimeSeconds * 1000,
                cfContest.startTimeSeconds * 1000,
                cfContest.durationSeconds * 1000,
                cfContest.name,
                "false"
            )
            contests.add(contest)
        }
        return contests
    }
}