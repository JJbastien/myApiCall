package com.example.myapicall.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapicall.model.JokeResponse
import com.example.myapicall.rest.JokeRepository
import com.example.myapicall.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class JokeViewModel @Inject constructor(
    private val jokeRepository: JokeRepository
) : ViewModel() {

    private val _jokes: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
   val jokes:LiveData<UIState>get() = _jokes

    fun getJoke(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
               val response =  jokeRepository.getRandom()
                if (response.isSuccessful){
                    response.body()?.let {
                        withContext(Dispatchers.Main){
                        _jokes.value = UIState.SUCCESS(it)
                        }
                    } ?: throw Exception("DATA IS NULL")
                } else{
                    throw  Exception(response.errorBody()?.string())
                }
            }
            catch (e: Exception){
                withContext(Dispatchers.Main){
                _jokes.postValue(UIState.ERROR(e))
                }
            }
        }
    }
    fun getListOfJokes(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response =  jokeRepository.getNonEndinglist()
                if (response.isSuccessful){
                    response.body()?.let {
                        withContext(Dispatchers.Main){
                            _jokes.value = UIState.SUCCESS(it)
                        }
                    } ?: throw Exception("DATA IS NULL")
                } else{
                    throw  Exception(response.errorBody()?.string())
                }
            }
            catch (e: Exception){
                withContext(Dispatchers.Main){
                    _jokes.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    fun getYourCustomJoke(firstName: String, lastName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response =  jokeRepository.getCustomJoke(firstName ,lastName)
                if (response.isSuccessful){
                    response.body()?.let {
                        withContext(Dispatchers.Main){
                            _jokes.value = UIState.SUCCESS(it)
                        }
                    } ?: throw Exception("DATA IS NULL")
                } else{
                    throw  Exception(response.errorBody()?.string())
                }
            }
            catch (e: Exception){
                withContext(Dispatchers.Main){
                    _jokes.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}