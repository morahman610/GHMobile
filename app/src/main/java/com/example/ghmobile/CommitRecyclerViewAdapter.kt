package com.example.ghmobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ghmobile.Data.CommitResponseItem
import com.example.ghmobile.databinding.CommitItemBinding

class CommitRecyclerViewAdapter(private val commitList: List<CommitResponseItem>) :
    RecyclerView.Adapter<CommitRecyclerViewAdapter.CommitViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitViewHolder {
        val binding = CommitItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return CommitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommitViewHolder, position: Int) {
        val currentCommit = commitList[position]

        holder.binding.commitAuthor.text = currentCommit.commit.author.name
        holder.binding.commitHash.text = currentCommit.sha
        holder.binding.commitMessage.text = currentCommit.commit.message
    }

    override fun getItemCount(): Int {
        return commitList.size
    }

    inner class CommitViewHolder(val binding: CommitItemBinding)
        : RecyclerView.ViewHolder(binding.root)

}