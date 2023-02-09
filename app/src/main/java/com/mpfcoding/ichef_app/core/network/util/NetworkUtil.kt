package com.mpfcoding.ichef_app.core.network.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NetworkUtil {
    companion object{
        fun objectToQueryParams(aRequest: Any?): Map<String, String> {
            val lJson = Gson().toJson(aRequest)
            val lType = object : TypeToken<Map<String, String>>() {}.type
            return Gson().fromJson(lJson, lType)
        }
    }
}