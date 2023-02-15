package com.mpfcoding.ichef_app.core.domain

data class Store(
    val id: Long = 0L,
    val name: String = "",
    val timeToDone: String = "",
    val logo: String = "",
    val city: String = "",
    val nameStreet: String = "",
    val numberHouse: String = "",
    val neighborood: String = ""
)