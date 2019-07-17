package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
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
//    imm.hideSoftInputFromWindow(butCalculate.getWindowToken(),
//        InputMethodManager.HIDE_NOT_ALWAYS);

//getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
//if (imm.isActive)
//imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)


//fun Activity.hideKeyboard() {
//    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//    imm.hideSoftInputFromWindow(windowToken, 0)
//}