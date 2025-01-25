package br.com.lno.androidmvvm.domain.model

data class ToDo(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)