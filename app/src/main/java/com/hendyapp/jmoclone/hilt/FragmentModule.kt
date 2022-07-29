package com.hendyapp.jmoclone.hilt

import android.content.Context
import com.hendyapp.jmoclone.view.adapter.BeritaAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {
    @FragmentScoped
    @Provides
    fun provideBeritaAdapter(@ActivityContext context: Context): BeritaAdapter {
        return BeritaAdapter(context)
    }
}