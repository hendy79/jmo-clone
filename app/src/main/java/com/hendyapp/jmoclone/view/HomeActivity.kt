package com.hendyapp.jmoclone.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.hendyapp.jmoclone.R
import com.hendyapp.jmoclone.databinding.ActivityHomeBinding
import com.hendyapp.jmoclone.view.fragment.BerandaFragment
import com.hendyapp.jmoclone.view.fragment.BeritaFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        replaceFragment(BerandaFragment())

        binding.aHomeBottomnav.setOnItemSelectedListener {
            it.isChecked = true
            when(it.itemId) {
                R.id.m_home_beranda -> {
                    replaceFragment(BerandaFragment())
                }
                R.id.m_home_berita -> {
                    replaceFragment(BeritaFragment())
                }
            }
            return@setOnItemSelectedListener false
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.a_home_fragment, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}