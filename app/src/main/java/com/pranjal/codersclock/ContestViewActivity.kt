package com.pranjal.codersclock

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pranjal.codersclock.adapter.ContestAdapter
import com.pranjal.codersclock.api.RetrofitInstance
import com.pranjal.codersclock.databinding.ContestViewBinding
import com.pranjal.codersclock.models.Contest
import com.pranjal.codersclock.utils.ResponseUtil
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class ContestViewActivity : AppCompatActivity() {

    private lateinit var binding: ContestViewBinding
    private lateinit var contestAdapter: ContestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContestViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        val site = intent.getStringExtra("site")
        getContests(site!!)
        //refreshContestData()
    }

    private fun getContests(site: String) {
        lifecycleScope.launchWhenCreated {
            binding.contestProgressBar.isVisible = true
            val response: Response<List<Contest>>
            try {
                response = if (site == "all")
                    RetrofitInstance.contestApi.getAllContests()
                else if (site == "code_chef")
                    RetrofitInstance.contestApi.getCodeChefContest()
                else if (site == "code_forces")
                    RetrofitInstance.contestApi.getCodeforcesContest()
                else if (site == "leet_code")
                    RetrofitInstance.contestApi.getLeetCodeContest()
                else if (site == "hacker_rank")
                    RetrofitInstance.contestApi.getHackerRankContest()
                else if (site == "hacker_earth")
                    RetrofitInstance.contestApi.getHackerEarthContest()
                else
                    Response.error(404, null)
            } catch (e: IOException) {
                Toast.makeText(
                    this@ContestViewActivity,
                    "Exception occured $e",
                    Toast.LENGTH_SHORT
                ).show()
                binding.contestProgressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Toast.makeText(
                    this@ContestViewActivity,
                    "Exception occured $e",
                    Toast.LENGTH_SHORT
                ).show()
                binding.contestProgressBar.isVisible = false
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                contestAdapter.contests = ResponseUtil.getContests(response.body()!!)
            } else {
                Toast.makeText(this@ContestViewActivity, "No data to show...", Toast.LENGTH_SHORT)
                    .show()
            }
            binding.contestProgressBar.isVisible = false
        }
    }

    private fun displayContests(contests: List<Contest>) {

    }

    private fun setupRecyclerView() = binding.contestRecyclerView.apply {
        contestAdapter = ContestAdapter()
        adapter = contestAdapter
        layoutManager = LinearLayoutManager(this@ContestViewActivity)
    }

}