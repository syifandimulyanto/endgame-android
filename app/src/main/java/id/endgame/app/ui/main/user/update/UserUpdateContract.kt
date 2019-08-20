package id.endgame.app.ui.main.user.update

import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

/**
 * Created by syifandimulyanto.id on 2019-08-20
 */
interface UserUpdateContract {

    interface Presenter<V : View> : MvpPresenter<V> {
    }

    interface View : MvpView {
    }
}