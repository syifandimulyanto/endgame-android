package id.endgame.app.ui.splash

import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

interface SplashContract {

    interface Presenter<V : View> :
        MvpPresenter<V> {
    }

    interface View : MvpView {
        fun openLoginActivity()
        fun openMainActivity()
    }
}