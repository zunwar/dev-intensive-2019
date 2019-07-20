package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager


//fun Activity.hideKeyboard () {
//    this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
//}


//fun Activity.hideKeyboard(view: View = this) {
//    hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
//}

fun Activity.hideKeyboard() {
    val  imm : InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive)
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
}


    fun Activity.getRootView(): View {
    return findViewById<View>(android.R.id.content)
    }

    fun Context.convertDpToPx(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            this.resources.displayMetrics
        )
    }

    fun Activity.isKeyboardOpen(): Boolean {
        val visibleBounds = Rect()
        this.getRootView().getWindowVisibleDisplayFrame(visibleBounds)
        val heightDiff = getRootView().height - visibleBounds.height()
        val marginOfError = Math.round(this.convertDpToPx(50F))
        return heightDiff > marginOfError
    }

    fun Activity.isKeyboardClosed(): Boolean {
        return !this.isKeyboardOpen()
    }


//rootView.getWindowVisibleDisplayFrame(Rect())
//**Activity.isKeyboardOpen Activity.isKeyboardClosed











//    imm.hideSoftInputFromWindow(butCalculate.getWindowToken(),
//        InputMethodManager.HIDE_NOT_ALWAYS);

//getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
//if (imm.isActive)
//imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)


//fun Activity.hideKeyboard() {
//    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//    imm.hideSoftInputFromWindow(windowToken, 0)
//}