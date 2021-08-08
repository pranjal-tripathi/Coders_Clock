package com.pranjal.codersclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pranjal.codersclock.adapter.ContestAdapter
import com.pranjal.codersclock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var contestAdapter: ContestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, ContestViewActivity::class.java).apply {  }
        binding.upcomingButton.setOnClickListener() {
            startActivity(intent)
        }
    }

    private fun setUpRecyclerViewAdapter() = binding.reminderSetRV.apply {
        contestAdapter = ContestAdapter()
        adapter = contestAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}