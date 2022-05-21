package ru.maksewsha.absmovies.presentation.utils

import android.text.TextUtils
import android.util.Patterns
import android.util.TypedValue
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import ru.maksewsha.absmovies.R

fun Fragment.checkValid(email: EditText, pass: EditText): Boolean {
    return !TextUtils.isEmpty(email.text) && !TextUtils.isEmpty(email.text) && Patterns.EMAIL_ADDRESS.matcher(
        email.text
    ).matches() && pass.text.length > 6
}

fun getStringList(list: List<Any>): String {
    val result: StringBuilder = StringBuilder("")
    if (list.size > 1) {
        for (ind in 0..list.size - 2) {
            result.append(list.get(ind).toString() + ", ")
        }
        result.append(list.last().toString())
    } else {
        result.append(list.get(0).toString())
    }
    return result.toString()
}

fun setRateColor(rate: Double?, textHolder: TextView) {
    if (rate == null) {
        textHolder.setTextSize(
            TypedValue.COMPLEX_UNIT_SP,
            textHolder.context.resources.getDimension(R.dimen.middle_text).toFloat()
        )
        textHolder.text = textHolder.context.getString(R.string.rating_null)
        textHolder.setTextColor(ContextCompat.getColor(textHolder.context, R.color.rating_red))
    } else {
        textHolder.text = rate.toString()
        when (rate) {
            in 0.0..4.0 -> textHolder.setTextColor(
                ContextCompat.getColor(
                    textHolder.context,
                    R.color.rating_red
                )
            )
            in 4.1..8.0 -> textHolder.setTextColor(
                ContextCompat.getColor(
                    textHolder.context,
                    R.color.rating_yellow
                )
            )
            in 8.1..10.0 -> textHolder.setTextColor(
                ContextCompat.getColor(
                    textHolder.context,
                    R.color.rating_green
                )
            )
            else -> {}
        }
    }
}