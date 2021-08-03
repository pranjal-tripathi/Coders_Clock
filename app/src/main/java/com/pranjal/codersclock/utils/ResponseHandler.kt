package com.pranjal.codersclock.utils

import com.pranjal.codersclock.models.CodeforcesContest
import com.pranjal.codersclock.models.Contest
import com.pranjal.codersclock.models.ResponseRe

object ResponseHandler {

    fun handleRawResponse(response: ResponseRe) = response.result

    fun handleCodeforcesResponse(response: List<CodeforcesContest>) : List<Contest> {
        var contests: MutableList<Contest> = mutableListOf()
        for(cfContest in response) {
            var contest = Contest(
                cfContest.startTimeSeconds.toString(),
                null,
                null,
                null,
                cfContest.startTimeSeconds.toString(),
                null,
                null,
                cfContest.name,
                null
            )
            contests.add(contest)
        }
        return contests
    }
}