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
import com.pranjal.codersclock.utils.ResponseHandler
import retrofit2.HttpException
import java.io.IOException

class ContestViewActivity : AppCompatActivity() {

    private lateinit var binding: ContestViewBinding
    private lateinit var contestAdapter: ContestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContestViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        refreshContestData()
    }

    private fun setupRecyclerView() = binding.contestRecyclerView.apply {
        contestAdapter = ContestAdapter()
        adapter = contestAdapter
        layoutManager = LinearLayoutManager(this@ContestViewActivity)
    }

    private fun refreshContestData() {
        lifecycleScope.launchWhenCreated {
            binding.contestProgressBar.isVisible = true
            val response = try {
                RetrofitInstance.codeforcesApi.getCodeforcesContest()
            } catch (e: IOException) {
                Toast.makeText(this@ContestViewActivity, "Exception occured $e", Toast.LENGTH_SHORT).show()
                binding.contestProgressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Toast.makeText(this@ContestViewActivity, "Exception occured $e", Toast.LENGTH_SHORT).show()
                binding.contestProgressBar.isVisible = false
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                contestAdapter.contests = ResponseHandler.handleCodeforcesResponse(ResponseHandler
                    .handleRawResponse(response.body()!!))
            } else {
                Toast.makeText(this@ContestViewActivity, "No data to show...", Toast.LENGTH_SHORT).show()
            }
            binding.contestProgressBar.isVisible = false
        }
    }
}