package id.endgame.app.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import com.google.android.material.snackbar.Snackbar

/**
 * Created by @adriyoutomo on 27/06/2019.
 */

fun Snackbar.withColor(@ColorInt colorInt: Int): Snackbar{
    this.view.setBackgroundColor(colorInt)
    return this
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toInvisible() {
    this.visibility = View.INVISIBLE
}

fun Context?.toast(text: String) = this?.let { Toast.makeText(it, text, Toast.LENGTH_SHORT).show() }

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}