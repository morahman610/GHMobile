package com.example.ghmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ghmobile.Data.CommitResponseItem
import com.example.ghmobile.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var commitRecyclerViewAdapter : CommitRecyclerViewAdapter
    private var commitList = mutableListOf<CommitResponseItem>()

    private lateinit var binding: ActivityMainBinding


    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        viewModel = MainActivityViewModel()

        commitRecyclerViewAdapter = CommitRecyclerViewAdapter(commitList)


        lifecycleScope.launchWhenCreated {
            val commits = viewModel.getCommits()

            try {
                if (commits.isSuccessful) {
                    commitList = commits.body()!!
                    commitRecyclerViewAdapter = CommitRecyclerViewAdapter(commitList)
                    binding.commitRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.commitRecyclerView.adapter = commitRecyclerViewAdapter

                } else {
                    Log.d(TAG, "error message: ${commits.errorBody()}")
                }
            } catch (e : Exception) {
                Log.d(TAG, "error message: ${e.localizedMessage}")
            }
        }
    }
}