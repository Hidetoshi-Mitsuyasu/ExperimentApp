package com.example.hmitsuyasu.myapplication.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.hmitsuyasu.myapplication.R

class PagePagerAdapter(childFragmentManager: FragmentManager, urls: Any) :
    FragmentStatePagerAdapter(childFragmentManager) {
    private val TAB_TYPE_MAX: Int = 2

    override fun getItem(i: Int): Fragment {
        return PageFragment.newInstance(R.drawable.image_walkthrew_1)
    }

    override fun getCount(): Int {
        return TAB_TYPE_MAX
    }
}
