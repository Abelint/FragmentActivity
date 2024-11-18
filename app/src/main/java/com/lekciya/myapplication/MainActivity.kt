package com.lekciya.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToDetail = findViewById<Button>(R.id.btnGoToDetail)
        btnGoToDetail.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Привет из MainActivity!")
            startActivity(intent)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Устанавливаем первый фрагмент по умолчанию
        replaceFragment(Fragment1())

        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_fragment1 -> replaceFragment(Fragment1())
                R.id.nav_fragment2 -> replaceFragment(Fragment2())
                R.id.nav_fragment3 -> replaceFragment(Fragment3())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}