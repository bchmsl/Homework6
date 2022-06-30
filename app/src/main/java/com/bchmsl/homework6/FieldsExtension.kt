package com.bchmsl.homework6

import android.text.Editable
import android.util.Patterns

fun checkFields(
    firstName: Editable?,
    lastName: Editable?,
    email: Editable?,
    age: Editable?
): Boolean {
    return if (firstName.isNullOrEmpty()) false
    else if (lastName.isNullOrEmpty()) false
    else if (email.isNullOrEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email.toString())
            .matches()
    ) false
    else if (!age.isNullOrEmpty()) {
        try {
            age.toString().toInt()
            true
        } catch (e: Exception) {
            false
        }
    } else {
        true
    }
}