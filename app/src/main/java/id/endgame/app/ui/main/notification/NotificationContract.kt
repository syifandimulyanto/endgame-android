package id.endgame.app.ui.main.notification

import id.endgame.app.data.entity.model.Notification
import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
interface NotificationContract {

    interface Presenter<V : View> :
        MvpPresenter<V> {
    }

    interface View : MvpView {
        fun setNotifications(notifications: List<Notification>?)
    }
}