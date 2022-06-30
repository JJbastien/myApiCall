package com.example.myapicall.View

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapicall.JokesAdapter
import com.example.myapicall.R
import com.example.myapicall.databinding.FragmentSingleJokeBinding
import com.example.myapicall.model.JokeResponse
import com.example.myapicall.model.Jokes
import com.example.myapicall.utils.UIState
import com.example.myapicall.viewModel.JokeViewModel
import retrofit2.Response


class SingleJokeFragment : BaseFragment() {

    private val binding by lazy {
        FragmentSingleJokeBinding.inflate(layoutInflater)
    }
    private val jokeAdapter by lazy{
        JokesAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
            jokeViewModel.jokes.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is UIState.LOADING -> {
                      //  binding.loadingSpinnerCardView.visibility = View.VISIBLE

                    }
                    is UIState.SUCCESS<*> -> {
                        binding.loadingSpinnerCardView.visibility = View.GONE
                        binding.jokeDisplay.visibility = View.VISIBLE
                        fun bind(joke: Jokes) {
                            binding.jokeDisplay.text = joke.joke
                        }
                    }
                    is UIState.ERROR -> {
                        binding.loadingSpinnerCardView.visibility = View.GONE

                    }
                }
            }
            binding.btnCardview.setOnClickListener {
                jokeViewModel.getJoke()
        }
        binding.btnCardview2.setOnClickListener{
            findNavController().navigate(R.id.action_singleJokeFragment_to_editFragment)
        }
        binding.btnCardview3.setOnClickListener{
            findNavController().navigate(R.id.action_singleJokeFragment_to_infiniteListFragment)
        }
        return binding.root
    }

}