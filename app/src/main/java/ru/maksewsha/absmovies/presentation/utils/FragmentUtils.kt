package ru.maksewsha.absmovies.presentation.utils

import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import androidx.fragment.app.Fragment

fun Fragment.checkValid(email: EditText, pass: EditText): Boolean {
    return !TextUtils.isEmpty(email.text) && !TextUtils.isEmpty(email.text) && Patterns.EMAIL_ADDRESS.matcher(
        email.text
    ).matches() && pass.text.length > 6
}