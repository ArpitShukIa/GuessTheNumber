package com.example.guessthenumber.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ScoreViewModelFactory(private val attempts: Int, private val number: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(attempts, number) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}