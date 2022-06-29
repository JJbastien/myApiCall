package com.example.myapicall.View

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapicall.JokesAdapter
import com.example.myapicall.R
import com.example.myapicall.databinding.FragmentInfiniteListBinding
import com.example.myapicall.utils.UIState
import com.example.myapicall.viewModel.JokeViewModel


class InfiniteListFragment : BaseFragment() {
    private val binding by lazy {
        FragmentInfiniteListBinding.inflate(layoutInflater)
    }

  private val jokeAdapter by lazy {
        JokesAdapter()

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.infiniteRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = jokeAdapter

        }
            jokeViewModel.jokes.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is UIState.LOADING -> {
                        binding.rcLoadingSpinner.visibility = View.VISIBLE
                        binding.infiniteRecyclerView.visibility = View.GONE
                    }
                    is UIState.SUCCESS<*> -> {
                        binding.rcLoadingSpinner.visibility = View.GONE
                        binding.infiniteRecyclerView.visibility = View.VISIBLE
                    }
                    is UIState.ERROR -> {
                        binding.rcLoadingSpinner.visibility = View.GONE
                        binding.infiniteRecyclerView.visibility = View.GONE
                    }
                }
            }


        jokeViewModel.getListOfJokes()
        return binding.root
    }


}