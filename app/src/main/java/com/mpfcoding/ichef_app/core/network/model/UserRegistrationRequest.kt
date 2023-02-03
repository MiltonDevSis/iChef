package com.mpfcoding.ichef_app.core.network.model

import com.google.gson.annotations.SerializedName

data class UserRegistrationRequest(

    @SerializedName("nome")
    var nome: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("telefone")
    var telefone: String? = null,

    @SerializedName("senha")
    var senha: String? = null,

    @SerializedName("ReceberPromocoes")
    var receberPromo: String? = null
    )