package id.endgame.app.ui.main.user.password

import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

/**
 * Created by syifandimulyanto.id on 2019-08-20
 */
interface UserPasswordContract {

    interface Presenter<V : View> : MvpPresenter<V> {
    }

    interface View : MvpView {
    }
}