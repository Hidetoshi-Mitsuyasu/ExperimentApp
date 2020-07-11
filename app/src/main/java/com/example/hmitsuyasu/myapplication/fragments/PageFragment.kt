package com.example.hmitsuyasu.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.hmitsuyasu.myapplication.R


class PageFragment : Fragment() {
    private var im: ImageView? = null
    private var bundleResId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundleResId = arguments!!.getInt(ARGS_RES_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflateView = inflater.inflate(R.layout.fragment_warlthrow, container, false)
        im = inflateView.findViewById(R.id.imageView2) as ImageView
        return inflateView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        im?.setImageDrawable(ResourcesCompat.getDrawable(view.resources, bundleResId, null))
    }


    companion object {
        private const val ARGS_RES_ID = "ARGS_RES_ID"
        fun newInstance(resID: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt(ARGS_RES_ID, resID)
            fragment.arguments = args

            return fragment
        }
    }
}