package com.hendyapp.jmoclone.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hendyapp.jmoclone.api.ApiService
import com.hendyapp.jmoclone.model.PostResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PublicRepo(private val apiService: ApiService) {
    fun getPosts(): LiveData<List<PostResponse>> {
        val mld = MutableLiveData<List<PostResponse>>()
        val single = Single.create<List<PostResponse>> { emitter ->
            apiService.getPosts()?.execute()?.let {
                emitter.onSuccess(it.body()!!)
            }
        }
        single.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<List<PostResponse>>() {
                override fun onSuccess(t: List<PostResponse>) {
                    mld.postValue(t)
                }

                override fun onError(e: Throwable) {
                    mld.postValue(arrayListOf())
                }
            })
        return mld
    }
}