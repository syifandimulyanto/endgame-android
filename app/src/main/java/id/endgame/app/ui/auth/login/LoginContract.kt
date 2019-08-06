package id.endgame.app.ui.auth.login

import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

interface LoginContract {

    interface Presenter<V : View> :
        MvpPresenter<V> {
        fun procesLogin(email: Any, password: Any)
    }

    interface View : MvpView {
        fun showErrorLoginPhone(error_login_phone: Int)
        fun showErrorLoginPassword(error_login_password: Int)
        fun openMainActivity()
    }
}