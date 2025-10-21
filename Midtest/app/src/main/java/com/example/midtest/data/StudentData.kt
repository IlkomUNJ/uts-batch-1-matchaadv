package com.example.midtest.data

data class Student(
    val id: String,
    val name: String,
    val phone: String,
    val address: String
)

object StudentRepository {
    val studentList = mutableListOf<Student>()
}