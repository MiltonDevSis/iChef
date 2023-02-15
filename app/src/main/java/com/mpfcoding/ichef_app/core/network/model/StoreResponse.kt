package com.mpfcoding.ichef_app.core.network.model

import com.google.gson.annotations.SerializedName
import com.mpfcoding.ichef_app.core.domain.Store

data class StoreResponse(

    @SerializedName("name")
    var nome: String = "",

    @SerializedName("time_to_done")
    var timeToDone: String = "",

    @SerializedName("logo")
    var logo: String? = "",

    @SerializedName("city")
    var city: String = "",

    @SerializedName("nameStreet")
    var nameStreet: String = "",

    @SerializedName("houseNumber")
    var numberHouse: String = "",

    @SerializedName("neighborhood")
    var neighborhood: String = "",
)

fun StoreResponse.toDoamin(): Store {
    return Store(
        name = this.nome,
        timeToDone = this.timeToDone,
        city = this.city,
        logo = "",
        nameStreet = this.nameStreet,
        numberHouse = this.numberHouse,
        neighborood = this.neighborhood
    )
}