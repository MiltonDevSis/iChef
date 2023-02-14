package com.mpfcoding.ichef_app.core.domain

data class Store(
    val id: Long = 0L,
    val name: String = "",
    val stars: Double = 0.0,
    val timeToDone: String = "",
    val logo: String = "",
    val address: Address = Address()
)

data class Address(
    val city: String = "",
    val nameStreet: String = "",
    val numberHouse: String = "",
    val neighborood: String = ""
)

val stores = listOf(
    Store(
        id = 1L,
        name = "x-salada",
        stars = 4.5,
        timeToDone = "15 - 30 min",
        logo = "",
        address = Address(
            city = "Cocal do sul",
            nameStreet = "Teste",
            numberHouse = "123",
            neighborood = "Teste"
        )
    ),
    Store(
        id = 2L,
        name = "churrasquinho",
        stars = 4.5,
        timeToDone = "15 - 30 min",
        logo = "",
        address = Address(
            city = "Cocal do sul",
            nameStreet = "Teste",
            numberHouse = "123",
            neighborood = "Teste"
        )
    ),
    Store(
        id = 3L,
        name = "Espetinho",
        stars = 4.5,
        timeToDone = "15 - 30 min",
        logo = "",
        address = Address(
            city = "Cocal do sul",
            nameStreet = "Teste",
            numberHouse = "123",
            neighborood = "Teste"
        )
    )
)