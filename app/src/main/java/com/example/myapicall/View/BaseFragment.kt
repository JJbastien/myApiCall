package com.example.myapicall.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapicall.R
import com.example.myapicall.rest.JokeRepository
import com.example.myapicall.rest.JokeRepositoryImpl
import com.example.myapicall.viewModel.JokeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {



    protected val jokeViewModel by lazy{
        ViewModelProvider(
            requireActivity())[JokeViewModel::class.java]
    }



}