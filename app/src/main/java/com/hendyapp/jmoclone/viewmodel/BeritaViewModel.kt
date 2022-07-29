package com.hendyapp.jmoclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hendyapp.jmoclone.model.PostResponse
import com.hendyapp.jmoclone.repo.PublicRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BeritaViewModel @Inject constructor(private val publicRepo: PublicRepo): ViewModel() {
    fun getPosts(): LiveData<List<PostResponse>> {
        return publicRepo.getPosts()
    }
}