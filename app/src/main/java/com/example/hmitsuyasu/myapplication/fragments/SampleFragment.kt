package com.example.hmitsuyasu.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hmitsuyasu.myapplication.databinding.FragmentSampleBinding
import com.example.hmitsuyasu.myapplication.models.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SampleFragment : Fragment() {
    private lateinit var binding: FragmentSampleBinding
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSampleBinding.inflate(inflater, container, false).apply {
            viewModel = loginViewModel
            owner = this@SampleFragment
        }
        lifecycle.addObserver(loginViewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            lifecycleOwner = this@SampleFragment
        }

    }
}