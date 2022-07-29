package com.hendyapp.jmoclone.api

import com.hendyapp.jmoclone.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<PostResponse>>?
}