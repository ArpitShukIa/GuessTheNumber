package com.example.guessthenumber.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _guess = MutableLiveData<Int>()
    val guess: LiveData<Int>
        get() = _guess

    private val _attempts = MutableLiveData<Int>()
    val attempts: LiveData<Int>
        get() = _attempts

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    private lateinit var digits: MutableList<Int>

    init {
        resetList()
        nextGuess()
        _attempts.value = 1
    }

    private fun resetList() {
        digits = mutableListOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        )
        digits.shuffle()
    }

    private fun nextGuess() {
        _guess.value = digits.removeAt(0)
        if(digits.isEmpty()) {
            _eventGameFinish.value = true
        }
    }

    fun onCorrect() {
        _eventGameFinish.value = true
    }

    fun onWrong() {
        _attempts.value = (_attempts.value)?.plus(1)
        nextGuess()
    }

    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

}