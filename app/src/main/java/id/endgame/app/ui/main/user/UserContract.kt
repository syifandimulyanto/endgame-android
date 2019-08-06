package id.endgame.app.ui.main.user

import id.endgame.app.data.entity.model.User
import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

/**
 * Created by syifandimulyanto.id on 2019-06-25
 */
interface UserContract {

    interface Presenter<V : View> :
        MvpPresenter<V> {
        fun createMenu()
        fun loadUser()
    }

    interface View : MvpView {
        fun displayMenu(menuList: List<ProfileMenuItem>)
        fun openLoginActivity()
        fun displayProfile(user: User?)
    }
}