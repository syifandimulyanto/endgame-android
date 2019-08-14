package id.endgame.app.ui.main.notification.detail

import id.endgame.app.data.entity.ScheduleResponse
import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
interface NotificationDetailContract {

    interface Presenter<V : View> : MvpPresenter<V> {
    }

    interface View : MvpView {
    }
}