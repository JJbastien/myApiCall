package com.example.myapicall

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapicall.databinding.FragmentInfiniteListBinding
import com.example.myapicall.databinding.FragmentSingleJokeBinding
import com.example.myapicall.model.JokeResponse
import com.example.myapicall.model.Jokes

class JokesAdapter(private val jokeSet: MutableList<Jokes> = mutableListOf(),

) : RecyclerView.Adapter<JokesAdapter.JokesViewHolder>(){

    class JokesViewHolder(private val binding : FragmentSingleJokeBinding ) : RecyclerView.ViewHolder(binding.root)  {
        fun bind(joke: Jokes){
            binding.jokeDisplay.text = joke.joke
        }
    }
        fun updateNewJokes(newJokes: List<Jokes>){
            jokeSet.clear()
            jokeSet.addAll(newJokes)
            notifyDataSetChanged()

        }
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder =
            JokesViewHolder(
                FragmentSingleJokeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )


     override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.bind(jokeSet[position])
     }

     override fun getItemCount(): Int = jokeSet.size




 }