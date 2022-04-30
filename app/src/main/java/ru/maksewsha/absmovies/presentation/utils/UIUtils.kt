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

fun getStringList(list: List<Any>): String{
    val result: StringBuilder = StringBuilder("")
    if (list.size > 1){
        for (ind in 0..list.size - 2){
            result.append(list.get(ind).toString() + ", ")
        }
        result.append(list.last().toString())
    } else {
        result.append(list.get(0).toString())
    }
    return result.toString()
}