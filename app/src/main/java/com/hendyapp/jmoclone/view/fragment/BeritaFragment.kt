package com.hendyapp.jmoclone.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hendyapp.jmoclone.databinding.FragmentBeritaBinding
import com.hendyapp.jmoclone.model.PostResponse
import com.hendyapp.jmoclone.view.adapter.BeritaAdapter
import com.hendyapp.jmoclone.viewmodel.BeritaViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BeritaFragment: Fragment() {

    private lateinit var binding: FragmentBeritaBinding

    private val viewModel: BeritaViewModel by viewModels()

    @Inject
    lateinit var adapter: BeritaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBeritaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fBeritaLainya.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.fBeritaLainya.adapter = adapter

        viewModel.getPosts().observe(viewLifecycleOwner) {
            if(it.isNotEmpty()) {
                binding.fBeritaTerbaru.iBeritaTitle.text = it.first().title
            }
            if(it.size > 1) {
                val mutablePosts = mutableListOf<PostResponse>()
                mutablePosts.addAll(it)
                mutablePosts.removeAt(0)
                adapter.submitList(mutablePosts)
            }
        }
    }
}