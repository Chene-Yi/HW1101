package com.example.lab5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {

    companion object {
        private const val PAGE_COUNT = 3
    }

    private val fragments = listOf(
        FirstFragment(),
        SecondFragment(),
        ThirdFragment()
    )

    override fun getItemCount(): Int = PAGE_COUNT

    override fun createFragment(position: Int): Fragment = fragments[position]
}
