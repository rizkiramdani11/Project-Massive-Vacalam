package com.example.project_massive_vacalam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Trending : AppCompatActivity() {
    private lateinit var tabLayout : TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: TrendingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trending)
        viewPager2 = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        adapter = TrendingAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Sekarang"
                }
                1 -> {
                    tab.text = "Minggu lalu"
                }
                2 -> {
                    tab.text = "Bulan lalu"
                }
            }
        }.attach()

        for (i in 0..2){
            val textView = LayoutInflater.from(this).inflate(R.layout.tab_title, null)
                    as TextView
            when (i) {
                0 -> textView.text = "Sekarang"
                1 -> textView.text = "Minggu lalu"
                2 -> textView.text = "Bulan lalu"
            }
            tabLayout.getTabAt(i)?.customView = textView
        }
    }
}