package com.example.ghmobile

import com.example.ghmobile.Data.Commit
import com.example.ghmobile.Data.CommitResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubAPIService {

    @GET("repos/{owner}/{repo}/commits")
    suspend fun getCommits(
        @Path("owner") owner : String,
        @Path("repo") repo : String,
        @Query("per_page") perPage : Int
    ) : Response<CommitResponse>
}