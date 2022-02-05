package com.pranjal.codersclock.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pranjal.codersclock.databinding.ContestViewAdapterBinding
import com.pranjal.codersclock.models.Contest

class ContestAdapter : RecyclerView.Adapter<ContestAdapter.ContestViewHolder>() {

    inner class ContestViewHolder(val binding: ContestViewAdapterBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        override fun onClick(v: View?) {

        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<Contest>() {
        override fun areItemsTheSame(oldItem: Contest, newItem: Contest): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Contest, newItem: Contest): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this@ContestAdapter, diffCallBack)
    var contests: List<Contest>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContestViewHolder {
        return ContestViewHolder(
            ContestViewAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ContestViewHolder, position: Int) {
        holder.binding.apply {
            val contest = contests[position]
            var name = contest.name
            var startTime = contest.startTime
            var endTime = contest.endTime
            contestText.text = "$name \n Start - $startTime \n End - $endTime"
        }
    }

    override fun getItemCount(): Int {
        return contests.size
    }
}