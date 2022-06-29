package com.example.myapicall.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapicall.R
import com.example.myapicall.databinding.FragmentEditBinding


class EditFragment : BaseFragment() {

    private val binding by lazy {
        FragmentEditBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.editTextBtn.setOnClickListener{
        val firstNameInput = binding.editFirstName.text.toString()
        val lastNameInput = binding.editLastName.text.toString()
            findNavController().navigate(R.id.action_editFragment_to_singleJokeFragment)
            jokeViewModel.getYourCustomJoke(firstNameInput, lastNameInput)

        }
        return binding.root
    }


}