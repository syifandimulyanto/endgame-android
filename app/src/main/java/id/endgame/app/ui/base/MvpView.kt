package id.endgame.app.ui.base

import androidx.annotation.StringRes

interface MvpView {
    fun onError(@StringRes resId: Int)
    fun onError(message: String?)
    fun isNetworkConnected(): Boolean
    fun hideKeyboard()
    fun showMessage(message: String)
    fun showMessage(@StringRes resId: Int)
    fun openActivityOnTokenExpire()
    fun showProgress()
    fun hideProgress()
}