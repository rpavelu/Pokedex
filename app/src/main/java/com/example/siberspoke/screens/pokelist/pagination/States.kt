package com.example.siberspoke.screens.pokelist.pagination

interface States<T> {
    fun refresh() = Unit
    fun showNextPage() = Unit
    fun newData(data: List<T>) = Unit
    fun fail(message: String) = Unit
}