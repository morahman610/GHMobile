package com.example.ghmobile

import androidx.lifecycle.ViewModel
import com.example.ghmobile.Data.Commit
import com.example.ghmobile.Data.CommitResponse
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    suspend fun getCommits() : Response<CommitResponse> {

        val commits = GitHubAPIServiceProvider.gitHubAPIService.getCommits("angular",
            "angular",
            25)
        return commits
    }
}