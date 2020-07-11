package com.example.hmitsuyasu.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.viewpager.widget.ViewPager
import com.example.hmitsuyasu.myapplication.R


class SampleDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_page, container, false)

        val viewPager = view.findViewById(R.id.pager) as ViewPager
        val adapter = PagePagerAdapter(childFragmentManager, "")
        viewPager.setAdapter(adapter)
        

        dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setCanceledOnTouchOutside(true)
        return view
    }
}