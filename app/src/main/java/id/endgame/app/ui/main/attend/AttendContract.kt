package id.endgame.app.ui.main.attend

import id.endgame.app.data.entity.AttendResponse
import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
interface AttendContract {

    interface Presenter<V : View> :
        MvpPresenter<V> {
    }

    interface View : MvpView {
        fun setAttends(attends: List<AttendResponse>?)
    }
}