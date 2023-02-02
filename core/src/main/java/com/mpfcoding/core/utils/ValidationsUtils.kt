package com.mpfcoding.core.utils

class ValidationsUtils {
    companion object{

        fun String.isValidFullName(): Boolean {
            val numberNames = 1
            val moreThanOneName = this.split("\\s+".toRegex()).size != numberNames
            return if (moreThanOneName) {
                this.split("\\s+".toRegex())[1].isNotEmpty()
            } else {
                false
            }
        }

        fun String.isPhoneValid(): Boolean {
            val regex = "^\\([0-9]{2}\\)[0-9]{5}-[0-9]{4}\$".toRegex()
            return this.matches(regex)
        }

        fun validatePassword(password: String): Boolean {
            if (!password.matches(".*\\d.*".toRegex())) return false
            if (!password.matches(".*[a-z].*".toRegex())) return false
            if (!password.matches(".*[A-Z].*".toRegex())) return false
            if (password.length < 8 || password.length > 20) return false
            if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*".toRegex())) return false

            val consecutiveNumbers = Regex("(?:(\\d)\\1{2,}|(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){3,})")
            if (consecutiveNumbers.containsMatchIn(password)) return false

            return true
        }
    }
}