package com.example.porfolioui.data

import androidx.annotation.StringRes
import com.example.porfolioui.R

data class Person (
    @StringRes val name: Int,
    @StringRes val description: Int
)

val listPeople = listOf(
    Person(R.string.project_1, R.string.project_description),
    Person(R.string.project_2, R.string.project_description),
    Person(R.string.project_3, R.string.project_description)
)