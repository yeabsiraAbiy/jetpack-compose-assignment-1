package com.example.flowlearn.data


data class Course(
    val title: String,
    val code: String,
    val creditHours: Int,
    val description: String,
    val prerequisites: List<String>
)