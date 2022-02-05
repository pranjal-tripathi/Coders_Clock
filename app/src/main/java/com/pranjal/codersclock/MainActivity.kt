package com.pranjal.codersclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pranjal.codersclock.adapter.ContestAdapter
import com.pranjal.codersclock.api.RetrofitInstance
import com.pranjal.codersclock.databinding.ActivityMainBinding
import com.pranjal.codersclock.utils.ResponseUtil
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var contestAdapter: ContestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpCurrentlyRunningRecyclerView()
        getCurrentlyRunningContests()
        val intent = Intent(this, ContestViewActivity::class.java).apply { }
        binding.upcomingButton.setOnClickListener() {
            intent.putExtra("site", "all")
            startActivity(intent)
        }
        binding.codechefButton.setOnClickListener() {
            intent.putExtra("site", "code_chef")
            startActivity(intent)
        }
        binding.leetcodeButton.setOnClickListener() {
            intent.putExtra("site", "leet_code")
            startActivity(intent)
        }
        binding.hackerearthButton.setOnClickListener() {
            intent.putExtra("site", "hacker_earth")
            startActivity(intent)
        }
        binding.hackerrankButton.setOnClickListener() {
            intent.putExtra("site", "hacker_rank")
            startActivity(intent)
        }
        binding.codeforcesButton.setOnClickListener() {
            intent.putExtra("site", "code_forces")
            startActivity(intent)
        }
    }

    private fun getCurrentlyRunningContests() {
        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.contestApi.getAllContests()
            } catch (e: IOException) {
                Toast.makeText(
                    this@MainActivity,
                    "Exception occured $e",
                    Toast.LENGTH_SHORT
                ).show()
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Toast.makeText(
                    this@MainActivity,
                    "Exception occured $e",
                    Toast.LENGTH_SHORT
                ).show()
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                contestAdapter.contests = ResponseUtil.getRunningContests(response.body()!!)
            } else {
                Toast.makeText(this@MainActivity, "No data to show...", Toast.LENGTH_SHORT)
                    .show()
            }
            binding.progressBar.isVisible = false
        }
    }

    private fun setUpCurrentlyRunningRecyclerView() = binding.currentlyRunningRV.apply {
        contestAdapter = ContestAdapter()
        adapter = contestAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}