package id.endgame.app.ui.main

import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

interface MainContract {

    interface Presenter<V : View> : MvpPresenter<V> {
    }

    interface View : MvpView {
    }
}